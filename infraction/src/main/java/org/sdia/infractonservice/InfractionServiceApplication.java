package org.sdia.infractonservice;

//import org.sdia.billingservice.entities.InfractionRepository;
//import org.sdia.billingservice.entities.ProductItemRepository;

import org.sdia.infractonservice.entities.Infraction;
import org.sdia.infractonservice.repository.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication

@EnableFeignClients
public class InfractionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(InfractionRepository infractionRepository){

        return args -> {
            Infraction infraction =new Infraction();
            infraction.setId(UUID.randomUUID().toString());
            infraction.setNum_radar(UUID.randomUUID().toString());
            infraction.setVitesse_vihecule(200.0);
            infraction.setVitesse_maximal_radar(60.0);
            infraction.setDateInfraction(new Date());
            infraction.setMontant_infraction(600.0);
            infraction.setMatricule_vehicule("tttddtt");
            //Radar radar = radarServiceClient.findRadarById("1L");
            //infraction.setNum_radar(radar.getId());
            //infraction.setVitesse_maximal_radar(radar.getVitesse_Max());
            Infraction infraction1 = infractionRepository.save(infraction);

            //inventoryServiceClient.findAll().getContent().forEach(p->{
              //  productItemRepository.save(new ProductItem(null,1,p.getId(),p.getPrice(),infraction,new Radar()));
           // });
            System.out.println("*************************");
           // System.out.println(radar.getId());
            //System.out.println(radar.getVitesse_Max());
            //System.out.println(radar.getLatitude());
        };
    }}

















