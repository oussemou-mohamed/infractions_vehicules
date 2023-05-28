package org.sdia.inventoryservice.service;


import org.sdia.inventoryservice.dto.VehiculeRequestDTO;
import org.sdia.inventoryservice.dto.VehiculeResponseDTO;
import org.sdia.inventoryservice.entities.Vehicule;
import org.sdia.inventoryservice.mappers.VehiculeMapper;
import org.sdia.inventoryservice.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional//traansaction de springe
public class VehiculeServiceImpl implements VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private VehiculeMapper vehiculeMapper;
    ////////////////////////////////////////////////////////////:
    @Override
    public VehiculeResponseDTO addvehicule(VehiculeRequestDTO vehiculeRequestDTO) {
        Vehicule vehicule= Vehicule.builder()
                .id(UUID.randomUUID().toString())
                .num_matriculation(vehiculeRequestDTO.getNum_matriculation())
                .marque(vehiculeRequestDTO.getMarque())
                .puissance_fiscale(vehiculeRequestDTO.getPuissance_fiscale())
                .modele(vehiculeRequestDTO.getModele())
                .proprietaire(vehiculeRequestDTO.getProprietaire())
                .build();
        Vehicule saveVehicule = vehiculeRepository.save(vehicule);
        VehiculeResponseDTO vehiculeResponseDTO = vehiculeMapper.fromVehicule(saveVehicule);
        return vehiculeResponseDTO;
    }
       ////////////////////////////////////////////////////////////
    @Override
    public VehiculeResponseDTO updateVehicule(String id, VehiculeRequestDTO vehiculeRequestDTO) {
        return null;
    }


}


















