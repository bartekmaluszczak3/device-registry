package org.example.device.registry.repository.value;

public class LocationQueries {
    public static final String CREATE_SQL = """
        INSERT INTO locations (
            location_id,
            name,
            address,
            latitude,
            longitude
        )
        VALUES (?, ?, ?, ?, ?)
        RETURNING *
        """;
}
