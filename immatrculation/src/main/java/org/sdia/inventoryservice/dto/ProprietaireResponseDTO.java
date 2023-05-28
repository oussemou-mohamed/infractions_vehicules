package org.sdia.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class ProprietaireResponseDTO {
    private String id;
    private Date date_naissance;
    private String nom;
    private String email;
}
