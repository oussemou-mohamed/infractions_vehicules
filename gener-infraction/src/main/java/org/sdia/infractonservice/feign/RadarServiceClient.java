package org.sdia.infractonservice.feign;

import org.sdia.infractonservice.model.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="RADAR-SERVICE")
public interface RadarServiceClient {
    @PostMapping(path = "/infractions")
    public Infraction saveveinfraction(@RequestBody Infraction infraction) ;

}