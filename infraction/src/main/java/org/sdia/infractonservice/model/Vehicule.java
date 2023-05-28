package org.sdia.infractonservice.model;

import lombok.Data;

@Data
public class Vehicule {
        private String id;
        private String num_matriculation;
        private String marque;
        private Integer puissance_fiscale;
        private String modele;
        private Proprietaire proprietaire;
}
