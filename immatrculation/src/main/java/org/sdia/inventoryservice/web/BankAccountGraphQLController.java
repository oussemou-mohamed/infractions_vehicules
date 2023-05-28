package org.sdia.inventoryservice.web;

import net.bytebuddy.implementation.bind.annotation.Argument;
import org.sdia.inventoryservice.entities.Proprietaire;
import org.sdia.inventoryservice.entities.Vehicule;
import org.sdia.inventoryservice.repositories.ProprietaireRepository;
import org.sdia.inventoryservice.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @QueryMapping
    public List<Proprietaire> proprietaires(){
        return proprietaireRepository.findAll();
    }
    @QueryMapping
    public List<Vehicule> vehicules(){
        return vehiculeRepository.findAll();
    }
    @QueryMapping
    public Vehicule vehiculeById(@Argument(0) String id){return vehiculeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));}


}

/*
record BankAccountDTO(Double balance,String type,String currency){

}*/



















