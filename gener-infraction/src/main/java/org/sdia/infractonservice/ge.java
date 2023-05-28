package org.sdia.infractonservice;

//import org.sdia.billingservice.entities.Gener_infractionRepositorie;
//import org.sdia.billingservice.entities.ProductItemRepository;

import org.sdia.infractonservice.feign.RadarServiceClient;
import org.sdia.infractonservice.model.Infraction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

@EnableFeignClients
public class ge {

    public static void main(String[] args) {
        SpringApplication.run(ge.class, args);
    }
    @Bean
    CommandLineRunner start(RadarServiceClient radarServiceClient){


        return args -> { Infraction infraction1=new Infraction();
            infraction1.setId("555pppp5");
            infraction1.setDateInfraction(new Date());
            infraction1.setMatricule_vehicule("555");
            infraction1.setNum_radar("555");
            infraction1.setVitesse_vihecule(32553.3);
            infraction1.setVitesse_maximal_radar(45533.3);
            infraction1.setMontant_infraction(252.3);
            System.out.println(radarServiceClient.saveveinfraction(infraction1));
        };

    }}

















