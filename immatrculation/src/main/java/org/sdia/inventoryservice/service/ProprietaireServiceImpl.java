package org.sdia.inventoryservice.service;

import org.sdia.inventoryservice.dto.ProprietaireRequestDTO;
import org.sdia.inventoryservice.dto.ProprietaireResponseDTO;
import org.sdia.inventoryservice.entities.Proprietaire;
import org.sdia.inventoryservice.mappers.ProprietaireMapper;
import org.sdia.inventoryservice.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional//traansaction de springe
public class ProprietaireServiceImpl implements ProprietaireService {
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private ProprietaireMapper proprietaireMapper;

    @Override
    public ProprietaireResponseDTO addproprietaire(ProprietaireRequestDTO proprietaireRequestDTO) {
        Proprietaire proprietaire=Proprietaire.builder()
                .id(UUID.randomUUID().toString())
                .nom(proprietaireRequestDTO.getNom())
                .date_naissance(proprietaireRequestDTO.getDate_naissance())
                .email(proprietaireRequestDTO.getEmail())
                .build();
        Proprietaire saveProprietaire  = proprietaireRepository.save(proprietaire);
        ProprietaireResponseDTO proprietaireResponseDTO = proprietaireMapper.fromProprietaire(saveProprietaire);
        return proprietaireResponseDTO;
    }

    @Override
    public ProprietaireResponseDTO updateProprietaire(String id, ProprietaireRequestDTO proprietaireRequestDTO) {
        return null;
    }
}


















