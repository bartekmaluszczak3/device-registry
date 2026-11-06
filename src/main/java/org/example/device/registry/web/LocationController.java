package org.example.device.registry.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.device.registry.service.LocationService;
import org.example.device.registry.web.dto.LocationRequest;
import org.example.device.registry.web.dto.LocationResponse;
import org.example.device.registry.web.mapper.WebMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
@AllArgsConstructor
@Slf4j
public class LocationController {
    private final WebMapper webMapper;
    private final LocationService locationService;

    @PostMapping()
    public ResponseEntity<LocationResponse> create(@RequestBody LocationRequest request){
        log.info("Received create location request");
        var response = locationService.create(request);
        return ResponseEntity.ok(webMapper.toLocationResponse(response));

    }

}
