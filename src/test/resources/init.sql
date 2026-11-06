CREATE TABLE locations (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    location_id    VARCHAR(50)  NOT NULL UNIQUE,
    name          VARCHAR(150) NOT NULL,
    address       VARCHAR(255),
    latitude       DOUBLE PRECISION,
    longitude       DOUBLE PRECISION,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);