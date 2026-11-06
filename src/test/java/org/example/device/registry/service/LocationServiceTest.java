package org.example.device.registry.service;

import org.example.device.registry.shared.IntegrationBase;
import org.example.device.registry.web.dto.LocationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class LocationServiceTest extends IntegrationBase {

    @Autowired
    LocationService locationService;
    @Test
    void shouldCreateALocationInDatabase(){
        // given
        LocationRequest locationRequest = sampleLocation();

        // when
        locationService.create(locationRequest);

        // then
        var locations = getAllLocations();
        Assertions.assertEquals(1, locations.size());
        var location = locations.get(0);
        Assertions.assertEquals("address", location.get("address"));
        Assertions.assertEquals("name", location.get("name"));
        Assertions.assertEquals(10.0, location.get("latitude"));
        Assertions.assertEquals(12.0, location.get("longitude"));
        Assertions.assertNotNull(location.get("location_id"));
        Assertions.assertNotNull(location.get("created_at"));

    }

}
