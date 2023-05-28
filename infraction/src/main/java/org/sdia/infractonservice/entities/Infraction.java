package org.sdia.infractonservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infraction {
    @Id
    private String id;
    private Date dateInfraction;
    private String matricule_vehicule;
    private String num_radar;
    private Double vitesse_vihecule;
    private Double vitesse_maximal_radar;
    private Double montant_infraction;

}
