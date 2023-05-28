package org.sdia.inventoryservice.service;


import org.sdia.inventoryservice.dto.VehiculeRequestDTO;
import org.sdia.inventoryservice.dto.VehiculeResponseDTO;

public interface VehiculeService {
     VehiculeResponseDTO addvehicule(VehiculeRequestDTO vehiculeRequestDTO) ;

     VehiculeResponseDTO updateVehicule(String id, VehiculeRequestDTO vehiculeRequestDTO);
}
