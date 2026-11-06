package org.example.device.registry.service;

import org.example.device.registry.domain.Location;
import org.example.device.registry.shared.IntegrationBase;
import org.example.device.registry.web.dto.LocationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


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

    @Test
    void shouldFindLocationByName() {
        // given
        LocationRequest locationRequest = sampleLocation();
        locationService.create(locationRequest);

        // when
        List<Location> searchedLocations = locationService.search("name", null);

        // then
        Assertions.assertEquals(1, searchedLocations.size());
        var location = searchedLocations.get(0);
        Assertions.assertEquals(location.getAddress(), "address");
        Assertions.assertEquals(10.0, location.getLatitude());
        Assertions.assertEquals(12.0, location.getLongitude());
    }

    @Test
    void shouldFindLocationByAddress() {
        // given
        LocationRequest locationRequest = sampleLocation();
        locationService.create(locationRequest);

        // when
        List<Location> searchedLocations = locationService.search(null, "address");

        // then
        Assertions.assertEquals(1, searchedLocations.size());
        var location = searchedLocations.get(0);
        Assertions.assertEquals(location.getName(), "name");
        Assertions.assertEquals(10.0, location.getLatitude());
        Assertions.assertEquals(12.0, location.getLongitude());
    }

    @Test
    void shouldFindLocationByAddressAndLocation() {
        // given
        LocationRequest firstLocation = sampleLocation();
        locationService.create(firstLocation);

        LocationRequest secondLocation = sampleLocation("dummy-address", "name");
        locationService.create(secondLocation);

        LocationRequest thirdLocation = sampleLocation("address", "dummy-name");
        locationService.create(thirdLocation);

        // when
        List<Location> searchedLocations = locationService.search("name", "address");

        // then
        Assertions.assertEquals(1, searchedLocations.size());
        var location = searchedLocations.get(0);
        Assertions.assertEquals(location.getName(), "name");
        Assertions.assertEquals(location.getAddress(), "address");
    }

    @Test
    void shouldReturnAllWhenNoArgumentsArePassed() {
        // given
        LocationRequest firstLocation = sampleLocation();
        locationService.create(firstLocation);

        LocationRequest secondLocation = sampleLocation("dummy-address", "name");
        locationService.create(secondLocation);

        LocationRequest thirdLocation = sampleLocation("address", "dummy-name");
        locationService.create(thirdLocation);

        // when
        List<Location> searchedLocations = locationService.search(null, null);

        // then
        Assertions.assertEquals(3, searchedLocations.size());
    }

}
