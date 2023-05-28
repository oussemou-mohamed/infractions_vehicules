package org.sdia.infractonservice.model;

import lombok.Data;

import java.util.Date;
@Data
public class Proprietaire {
    private Date date_naissance;
    private String nom;
    private String email;

}
