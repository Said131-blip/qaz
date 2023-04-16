package com.exemple.helpdesk.repository;

import com.exemple.helpdesk.models.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface materielrepository extends JpaRepository<Materiel, Long> {
}
