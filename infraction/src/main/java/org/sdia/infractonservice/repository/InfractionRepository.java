package org.sdia.infractonservice.repository;


import org.sdia.infractonservice.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction, String> {
}
