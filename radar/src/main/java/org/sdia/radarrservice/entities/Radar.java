package org.sdia.radarrservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Properties;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Radar {
    @Id
    private String id;
    private Double vitesse_Max ;
    private Double longitude;
    private Double Latitude;

}
