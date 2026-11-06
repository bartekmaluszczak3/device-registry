package org.example.device.registry.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.device.registry.domain.Location;
import org.example.device.registry.repository.LocationRepository;
import org.example.device.registry.repository.mapper.LocationMapper;
import org.example.device.registry.repository.value.LocationQueries;
import org.example.device.registry.web.dto.LocationRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
@Slf4j
@Repository
public class LocationRepositoryPostgres implements LocationRepository {
    private final JdbcTemplate jdbc;
    private final LocationMapper locationMapper;

    public LocationRepositoryPostgres(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.locationMapper = new LocationMapper();
    }

    @Transactional
    @Override
    public Location create(LocationRequest request, String locationId) {
        log.info("Trying to create location in the database");

        return jdbc.query(
                        (Connection connection) -> {
                            PreparedStatement ps = connection.prepareStatement(LocationQueries.CREATE_SQL);
                            ps.setString(1, locationId);
                            ps.setString(2, request.getName());
                            ps.setString(3, request.getAddress());
                            ps.setDouble(4, request.getLatitude());
                            ps.setDouble(5, request.getLongitude());
                            return ps;
                        },
                        locationMapper
                ).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "INSERT did not return the created location"
                ));
    }
}
