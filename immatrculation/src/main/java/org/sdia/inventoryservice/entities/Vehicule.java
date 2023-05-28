package org.sdia.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Vehicule {
    @Id
    private String id;
    private String num_matriculation;
    private String marque;
    private Integer puissance_fiscale;
    private String modele;

    @ManyToOne
    private Proprietaire proprietaire;

}
