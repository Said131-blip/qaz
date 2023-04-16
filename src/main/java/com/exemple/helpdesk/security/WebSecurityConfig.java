package com.exemple.helpdesk.security;

import com.exemple.helpdesk.security.jwt.AuthTokenFilter;
import com.exemple.helpdesk.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exemple.helpdesk.security.jwt.AuthEntryPointJwt;

import static com.exemple.helpdesk.models.ERole.ROLE_ADMIN;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	//
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
				.antMatchers("/addClient").permitAll()
				.antMatchers("/postmateril").permitAll()
				.antMatchers("/demande").permitAll()
				.antMatchers("/users").permitAll()

				.antMatchers("/demander").permitAll()
				.antMatchers("/demanders").permitAll()
				.antMatchers("/listdemande").permitAll()
				.antMatchers("/demanders/{id_demande}").permitAll()
				.antMatchers("/listdemande").permitAll()
				.antMatchers("/contacts/{id_demande}").permitAll()

				.antMatchers("/addDemande").permitAll()
				.antMatchers("/chercher").permitAll()
				.antMatchers("/changestatus/{id_demande}").permitAll()

				.antMatchers("/swagger-ui/swagger-ui-bundle.js").permitAll()
				.antMatchers("/swagger-ui/swagger-ui-standalone-preset.js").permitAll()

				.antMatchers("/demandes/{id}").permitAll()
				.antMatchers("/user").permitAll()
				.antMatchers("/demane/{id_demande}").permitAll()
				.antMatchers("/user/{id}").permitAll()
				.antMatchers("/materiel/{id_materiel}").permitAll()
				.antMatchers("/swagger-ui/index.html").permitAll()
				.antMatchers("/v3/api-docs/swagger-config").permitAll()
				.antMatchers("/v3/api-docs").permitAll()

				.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
