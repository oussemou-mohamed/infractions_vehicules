package org.sdia.inventoryservice;

import org.sdia.inventoryservice.entities.Proprietaire;
import org.sdia.inventoryservice.entities.Vehicule;
import org.sdia.inventoryservice.repositories.ProprietaireRepository;
import org.sdia.inventoryservice.repositories.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ImmatriculationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImmatriculationServiceApplication.class, args);
	}

    @Bean  //cet objet crée au demmarage
	CommandLineRunner start(ProprietaireRepository proprietaireRepository, VehiculeRepository vehiculeRepository, RepositoryRestConfiguration restConfiguration){//au demmaraje cet metode va sexecuter ,en inject
		restConfiguration.exposeIdsFor(Vehicule.class,Proprietaire.class);
		return  args -> { //retourn un fonction don en va faire quelque traitement,
			//ajouter des compte ,par le constructeur ou par bilder

			Stream.of("Mohamed","Hassan","Hind","Mallak").forEach(c->{
				Proprietaire proprietaire= Proprietaire.builder()
						.id(UUID.randomUUID().toString())
						.nom(c)
						.date_naissance(new Date())
						.email(c+"@gmail.com")
						.build();
				proprietaireRepository.save(proprietaire);});

			proprietaireRepository.findAll().forEach(proprietaire -> {

				for (int i = 0; i < 5; i++) {
					String v="25.A."+UUID.randomUUID().toString();
					Vehicule vehicule= Vehicule.builder()
							.id(v)
							.num_matriculation(v)
							.marque("Mercedis")
							.puissance_fiscale(10000)
							.modele(UUID.randomUUID().toString())
							.proprietaire(proprietaire)
							.build();
					vehiculeRepository.save(vehicule);
				}
			});


		};
	}
}
