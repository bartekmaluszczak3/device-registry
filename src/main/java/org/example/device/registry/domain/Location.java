package org.example.device.registry.domain;

import lombok.*;

import java.time.OffsetDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Location {
    private Long id;
    private String locationId;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private OffsetDateTime createdAt;
}

