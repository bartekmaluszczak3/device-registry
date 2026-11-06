package org.example.device.registry.repository;

import org.example.device.registry.domain.Location;
import org.example.device.registry.web.dto.LocationRequest;

public interface LocationRepository {
    Location create(LocationRequest request, String locationId);
}
