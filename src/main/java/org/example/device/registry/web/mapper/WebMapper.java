package org.example.device.registry.web.mapper;

import org.example.device.registry.domain.Location;
import org.example.device.registry.web.dto.LocationResponse;
import org.springframework.stereotype.Component;

@Component
public class WebMapper {

    public LocationResponse toLocationResponse(Location location) {
        return LocationResponse.builder()
                .locationId(location.getLocationId())
                .address(location.getAddress())
                .latitude(location.getLatitude())
                .name(location.getName())
                .longitude(location.getLongitude())
                .createdAt(location.getCreatedAt())
                .build();
    }
}
