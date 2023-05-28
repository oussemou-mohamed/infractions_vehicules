package org.sdia.radarrservice.web;
import org.sdia.radarrservice.entities.Radar;
import org.sdia.radarrservice.feign.InfractionServiceClient;
import org.sdia.radarrservice.feign.ImmatriculationServiceClient;
import org.sdia.radarrservice.model.Infraction;
import org.sdia.radarrservice.model.Proprietaire;
import org.sdia.radarrservice.model.Vehicule;
import org.sdia.radarrservice.repositories.RadarRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController//restfoul     //methode1 de cree rest api ou reste controller
//@AllArgsConstructor
//@RequestMapping("/api")//pour aceder a ce web service commencer pare
public class radarRestController {
    //////////////////////////////////////////////////////////////////////////
    private RadarRepository radarRepository;
    private ImmatriculationServiceClient immatriculationServiceClient;
    private InfractionServiceClient infractionServiceClient;

/////////////////////////////////////////////////////////////////////////////////


    public radarRestController(RadarRepository radarRepository, ImmatriculationServiceClient immatriculationServiceClient, InfractionServiceClient infractionServiceClient) {
        this.radarRepository = radarRepository;
        this.immatriculationServiceClient = immatriculationServiceClient;
        this.infractionServiceClient = infractionServiceClient;
    }

    /////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////
    @PostMapping("/radar")
    public Radar saveveradar(@RequestBody Radar radar){
        return radarRepository.save(radar);
    }
    /////////////////////////////////////////////////////////////////////
    @GetMapping("/radar")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Radar> radars(){
        return radarRepository.findAll();
    }
    @GetMapping("/proprietaire")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
     PagedModel<Proprietaire> proprietaire(){
        return immatriculationServiceClient.toutproprietaires();
    }
    @GetMapping("/infractions")//pour acceder a sete metode bankAccounts en utilise @GetMapping//si lentiter sappele bankAccount ,l url sappel bankaccouns en plurielle(norme reste foul)
    public List<Infraction> infractions(){
        return infractionServiceClient.infractiosLnist();
    }
    @PostMapping("/infractions")
    public Infraction saveveinfraction(@RequestBody Infraction infraction){
        System.out.println(infraction);
        infraction.setId(UUID.randomUUID().toString());
        return infractionServiceClient.save(infraction);
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
//////////////////////////////////////////////////////

    @GetMapping("/radar/{id}")
    public Radar radar(@PathVariable String id){//parmetre resoie a partire de pathe
        return radarRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("vehicule %s not found",id)));
    }
    //////////////////////////////////////////////////////
//save
    @PutMapping ("/radar/{id}")
    public Radar updateradar (@PathVariable String id, @RequestBody Radar radar) {
        return radarRepository.save(radar);
    }
    ///////////////////////////////////////////////////////////////
    @DeleteMapping("/radar/{id}")
    public void deleteradar(@PathVariable String id) {
        radarRepository.deleteById(id);
    }


}



