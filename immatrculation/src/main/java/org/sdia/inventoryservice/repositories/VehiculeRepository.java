package org.sdia.inventoryservice.repositories;

import org.sdia.inventoryservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule,String> {

}
