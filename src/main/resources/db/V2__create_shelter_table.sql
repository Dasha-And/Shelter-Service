CREATE TABLE IF NOT EXISTS Shelter
(
    id serial PRIMARY KEY,
    name character varying NOT NULL,
    longitude double precision NOT NULL,
    latitude double precision NOT NULL,
    telephone character varying NOT NULL,
    email character varying,
    site_url character varying
);