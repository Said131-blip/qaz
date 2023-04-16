package com.exemple.helpdesk.Pojo;

import com.exemple.helpdesk.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DemandePojo {
    private Date date;

    private String Allocation_motive ;

    private String status;
    private  String equipement;

    private  String model;

    private  String serial;

    private  String comment;
}
