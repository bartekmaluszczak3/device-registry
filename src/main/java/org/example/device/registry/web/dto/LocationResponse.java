package org.example.device.registry.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationResponse {
    private String locationId;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private OffsetDateTime createdAt;
}
