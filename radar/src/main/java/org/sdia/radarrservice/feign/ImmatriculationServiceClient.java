package org.sdia.radarrservice.feign;

import org.sdia.radarrservice.model.Proprietaire;
import org.sdia.radarrservice.model.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="IMMATRICULATION-SERVICE")
public interface ImmatriculationServiceClient {
    //@GetMapping(path = "/products/{id}?projection=fullProduct")
    @GetMapping(path = "/proprietaires")
    PagedModel<Proprietaire> toutproprietaires();

    //PagedModel<Radar> pageProduct(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size);
    @GetMapping(path = "/proprietaires/{id}")
    Proprietaire findproprietairesById(@PathVariable String id);

    @GetMapping(path = "/api/vihicules")
    List<Vehicule> vihicules();

    //PagedModel<Radar> pageProduct(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size);
    @GetMapping(path = "/api/vihicules/{id}")
    Vehicule findVihiculesById(@PathVariable String id);

}
