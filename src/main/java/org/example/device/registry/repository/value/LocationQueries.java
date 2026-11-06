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

    public static final String SEARCH_SQL = """
        SELECT *
        FROM locations
        WHERE 1 = 1
        """;
}
