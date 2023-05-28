package org.sdia.inventoryservice.service;


import org.sdia.inventoryservice.dto.ProprietaireRequestDTO;
import org.sdia.inventoryservice.dto.ProprietaireResponseDTO;

public interface ProprietaireService {
     ProprietaireResponseDTO addproprietaire(ProprietaireRequestDTO proprietaireRequestDTO) ;

     ProprietaireResponseDTO updateProprietaire(String id, ProprietaireRequestDTO proprietaireRequestDTO);

}
