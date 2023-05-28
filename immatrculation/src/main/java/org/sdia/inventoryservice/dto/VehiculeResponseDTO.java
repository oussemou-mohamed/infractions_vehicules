package org.sdia.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sdia.inventoryservice.entities.Proprietaire;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class VehiculeResponseDTO {
    private String id;
    private String num_matriculation;
    private String marque;
    private Integer puissance_fiscale;
    private String modele;
    private Proprietaire proprietaire;
}
