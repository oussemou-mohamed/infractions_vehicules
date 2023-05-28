package org.sdia.inventoryservice.mappers;

import org.sdia.inventoryservice.dto.ProprietaireResponseDTO;
import org.sdia.inventoryservice.entities.Proprietaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProprietaireMapper {
    public ProprietaireResponseDTO fromProprietaire(Proprietaire proprietaire){
        ProprietaireResponseDTO proprietaireResponseDTO=new ProprietaireResponseDTO();
        BeanUtils.copyProperties(proprietaire,proprietaireResponseDTO);
        return proprietaireResponseDTO;

    }
}
