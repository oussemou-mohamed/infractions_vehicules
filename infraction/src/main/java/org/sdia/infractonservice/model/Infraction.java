package org.sdia.infractonservice.model;

import lombok.Data;

import java.util.Date;
@Data
public class Infraction {
    private String id;
    private Date dateInfraction;
    private String matricule_vehicule;
    private String num_radar;
    private Double vitesse_vihecule;
    private Double vitesse_maximal_radar;
    private Double montant_infraction;
}
