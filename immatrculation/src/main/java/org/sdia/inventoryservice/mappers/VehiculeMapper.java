package org.sdia.inventoryservice.mappers;

import org.sdia.inventoryservice.dto.VehiculeResponseDTO;
import org.sdia.inventoryservice.entities.Vehicule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VehiculeMapper {
    public VehiculeResponseDTO fromVehicule(Vehicule vehicule){
        VehiculeResponseDTO vehiculeResponseDTO=new VehiculeResponseDTO();
        BeanUtils.copyProperties(vehicule,vehiculeResponseDTO);
        return vehiculeResponseDTO;

    }
}
