package org.example.device.registry.repository.mapper;

import org.example.device.registry.domain.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class LocationMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setId(rs.getObject("id", Long.class));
        location.setLocationId(rs.getString("location_id"));
        location.setName(rs.getString("name"));
        location.setAddress(rs.getString("address"));
        location.setLatitude(rs.getDouble("latitude"));
        location.setLongitude(rs.getDouble("longitude"));
        location.setCreatedAt(rs.getObject("created_at", OffsetDateTime.class));

        return location;
    }
}
