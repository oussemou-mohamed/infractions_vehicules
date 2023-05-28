package org.sdia.inventoryservice.repositories;

import org.sdia.inventoryservice.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource  // methode 2//Spring data Rest (definire tout les fonction standare pour tester noter web servise)
public interface ProprietaireRepository extends JpaRepository<Proprietaire,String> {

}
