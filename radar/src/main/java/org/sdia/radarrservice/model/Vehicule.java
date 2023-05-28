package org.sdia.radarrservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Transient;

@Data
public class Vehicule {
        private String id;
        private String num_matriculation;
        private String marque;
        private Integer puissance_fiscale;
        private String modele;
        private Proprietaire proprietaire;
}
