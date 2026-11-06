package org.example.device.registry.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.device.registry.domain.Location;
import org.example.device.registry.repository.LocationRepository;
import org.example.device.registry.web.dto.LocationRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location create(LocationRequest locationRequest){
      String locationId = UUID.randomUUID().toString();
      log.debug("Trying to save location with locationId : {}", locationId);
      return locationRepository.create(locationRequest, locationId);

    }
}
