package org.sdia.inventoryservice.web;

import org.sdia.inventoryservice.dto.ProprietaireRequestDTO;
import org.sdia.inventoryservice.dto.ProprietaireResponseDTO;
import org.sdia.inventoryservice.dto.VehiculeRequestDTO;
import org.sdia.inventoryservice.dto.VehiculeResponseDTO;
import org.sdia.inventoryservice.entities.Proprietaire;
import org.sdia.inventoryservice.entities.Vehicule;
import org.sdia.inventoryservice.mappers.ProprietaireMapper;
import org.sdia.inventoryservice.repositories.ProprietaireRepository;
import org.sdia.inventoryservice.repositories.VehiculeRepository;
import org.sdia.inventoryservice.service.ProprietaireService;
import org.sdia.inventoryservice.service.VehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//restfoul     //methode1 de cree rest api ou reste controller
@RequestMapping("/api")//pour aceder a ce web service commencer pare
public class ImmatriculationRestController {
    //////////////////////////////////////////////////////////////////////////
    private ProprietaireRepository proprietaireRepository;
    private VehiculeRepository vehiculeRepository;

    private ProprietaireService proprietaireService;
    private VehiculeService vehiculeService;
    private ProprietaireMapper proprietaireMapper;
/////////////////////////////////////////////////////////////////////////////////
    public ImmatriculationRestController(ProprietaireRepository proprietaireRepository, VehiculeRepository vehiculeRepository, ProprietaireService proprietaireService, VehiculeService vehiculeService, ProprietaireMapper proprietaireMapper) {
        this.proprietaireRepository = proprietaireRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.proprietaireService = proprietaireService;
        this.vehiculeService = vehiculeService;
        this.proprietaireMapper = proprietaireMapper;
    }
    /////////////////////////////////////////////////////////////////////////////
    @PostMapping("/vehicules/{id}")
    public VehiculeResponseDTO savevehicule(@RequestBody VehiculeRequestDTO vehiculeRequestDTO){
        return vehiculeService.addvehicule(vehiculeRequestDTO);
    }

    @PostMapping("/proprietaires/{id}")
    public ProprietaireResponseDTO saveproprietaires(@RequestBody ProprietaireRequestDTO proprietaireRequestDTO){
        return proprietaireService.addproprietaire(proprietaireRequestDTO);
    }

    /////////////////////////////////////////////////////////////////////
    @GetMapping("/proprietaires")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Proprietaire> proprietaireList(){
        return proprietaireRepository.findAll();
    }

    @GetMapping("/vihicules")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Vehicule> vihicules(){
        return vehiculeRepository.findAll();
    }
//////////////////////////////////////////////////////

    @GetMapping("/vihicules/{id}")
    public Vehicule vehicule(@PathVariable String id){//parmetre resoie a partire de pathe
        return vehiculeRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("vehicule %s not found",id)));
    }
    @GetMapping("/proprietaires/{id}")
    public Proprietaire proprietaire(@PathVariable String id){//parmetre resoie a partire de pathe
        return proprietaireRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("proprietaire %s not found",id)));
    }
    //////////////////////////////////////////////////////
//save
    @PutMapping ("/proprietaires/{id}")
    public Proprietaire updateproprietaires (@PathVariable String id, @RequestBody Proprietaire proprietaire) {
        Proprietaire account = proprietaireRepository.findById(id).orElseThrow();
        account.setNom(proprietaire.getNom());
        account.setDate_naissance(proprietaire.getDate_naissance());
        account.setEmail(proprietaire.getEmail());
        return proprietaireRepository.save(account);
    }

    @PutMapping ("/vehicule/{id}")
    public Vehicule updatevehicule (@PathVariable String id, @RequestBody Vehicule vehicule) {
        Vehicule vehicule1    = vehiculeRepository.findById(id).orElseThrow();
        vehicule1.setModele(vehicule.getModele());
        vehicule1.setNum_matriculation(vehicule.getNum_matriculation());
        vehicule1.setMarque(vehicule.getMarque());
        vehicule1.setPuissance_fiscale(vehicule.getPuissance_fiscale());
        vehicule1.setProprietaire(vehicule.getProprietaire());
        return vehiculeRepository.save(vehicule1);
    }
    ///////////////////////////////////////////////////////////////

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccountProprietaire(@PathVariable String id){
         proprietaireRepository.deleteById(id);
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteVehicule (@PathVariable String id){
        vehiculeRepository.deleteById(id);
    }

    }

