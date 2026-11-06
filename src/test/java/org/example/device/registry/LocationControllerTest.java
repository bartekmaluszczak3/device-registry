package org.example.device.registry;

import org.example.device.registry.shared.IntegrationBase;
import org.example.device.registry.web.dto.LocationRequest;
import org.example.device.registry.web.dto.LocationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

public class LocationControllerTest extends IntegrationBase {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldCreateLocation() {
        // given
        LocationRequest locationRequest = sampleLocation();

        // when
        var locationResponseResponseEntity = testRestTemplate.postForEntity("/api/v1/locations", locationRequest, LocationResponse.class);


        // then
        Assertions.assertTrue(locationResponseResponseEntity.getStatusCode().is2xxSuccessful());
        var body = locationResponseResponseEntity.getBody();
        Assertions.assertEquals("address", body.getAddress());
        Assertions.assertEquals("name", body.getName());
        Assertions.assertEquals(10.0, body.getLatitude());
        Assertions.assertEquals(12.0, body.getLongitude());
        Assertions.assertNotNull(body.getLocationId());
        Assertions.assertNotNull(body.getCreatedAt());
    }
}
