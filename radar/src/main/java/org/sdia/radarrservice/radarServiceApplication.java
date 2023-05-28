package org.sdia.radarrservice;
import org.sdia.radarrservice.entities.Radar;
import org.sdia.radarrservice.feign.ImmatriculationServiceClient;
import org.sdia.radarrservice.feign.InfractionServiceClient;
import org.sdia.radarrservice.model.Infraction;
import org.sdia.radarrservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class radarServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(radarServiceApplication.class, args);
	}
    @Bean  //cet objet crée au demmarage
	CommandLineRunner start(RadarRepository radarRepository, ImmatriculationServiceClient immatriculationServiceClient, InfractionServiceClient infractionServiceClient){//au demmaraje cet metode va sexecuter ,en inject
		return  args -> { //retourn un fonction don en va faire quelque traitement,
			//ajouter des compte ,par le constructeur ou par bilder
			Stream.of("Mohamed","Hassan","Hind","Mallak").forEach(c->{
				Radar radar= Radar.builder()
						.id(c)
						.vitesse_Max(50.5)
						.longitude(55.5)
						.Latitude(55.5)
						.build();
				radarRepository.save(radar);
			}
			);
			//System.out.println(immatriculationServiceClient.toutproprietaires());
			//System.out.println(immatriculationServiceClient.toutvihicules());
			/*Infraction infraction=new Infraction();
			infraction.setId("244l");
			infraction.setDateInfraction(new Date());
			infraction.setMatricule_vehicule("rrrfrfrf");
			infraction.setNum_radar("3232");
			infraction.setVitesse_vihecule(323.3);
			infraction.setVitesse_maximal_radar(433.3);
			infraction.setMontant_infraction(22.3);
			System.out.println(infractionServiceClient.save(infraction));*/
		};
	}
}
