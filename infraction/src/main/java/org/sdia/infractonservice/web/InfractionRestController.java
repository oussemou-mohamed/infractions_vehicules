package org.sdia.infractonservice.web;

import org.sdia.infractonservice.entities.Infraction;
import org.sdia.infractonservice.feign.ImmatriculationServiceClient;
import org.sdia.infractonservice.model.Vehicule;
import org.sdia.infractonservice.repository.InfractionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfractionRestController {
    private InfractionRepository infractionRepository;
    private ImmatriculationServiceClient immatriculationServiceClient;

    public InfractionRestController(InfractionRepository infractionRepository, ImmatriculationServiceClient immatriculationServiceClient) {
        this.infractionRepository = infractionRepository;
        this.immatriculationServiceClient = immatriculationServiceClient;
    }
    @GetMapping(path = "/fullBill/{id}")
    public Infraction getBill(@PathVariable (name = "id") String id){
    return infractionRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("vehicule %s not found",id)));
}
    @GetMapping("/infractions")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Infraction> infractiosLnist(){
        return infractionRepository.findAll();
    }
    @PostMapping("/infraction")
    public Infraction save(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @GetMapping("/vihicules")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Vehicule> vihicules(){
        List<Vehicule> toutvihicules = immatriculationServiceClient.vihicules();
        return toutvihicules;
    }
    @GetMapping("/vihicules/{id}")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public Vehicule getvehicule(@PathVariable(name = "id") String id){
        return immatriculationServiceClient.findVihiculesById(id);
    }
}



















