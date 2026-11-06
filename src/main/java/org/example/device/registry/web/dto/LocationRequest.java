package org.example.device.registry.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationRequest {
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
}
