package org.sdia.radarrservice.feign;
import org.sdia.radarrservice.model.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="INFRACTION-SERVICE")
public interface InfractionServiceClient {
    @GetMapping(path = "/infractions")
    List<Infraction> infractiosLnist();

    //PagedModel<Radar> pageProduct(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size);
    @GetMapping(path = "/vihicules/{id}")
    Infraction findVihiculesById(@PathVariable String id);
@PostMapping(path = "/infraction")
    public Infraction save(@RequestBody Infraction infraction);

}
