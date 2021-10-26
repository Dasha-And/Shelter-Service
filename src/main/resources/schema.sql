CREATE TABLE IF NOT EXISTS Shelter
(
    id serial NOT NULL,
    name character varying NOT NULL,
    longitude double precision NOT NULL,
    latitude double precision NOT NULL,
    phone character varying NOT NULL,
    email character varying,
    site_url character varying,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Animal
(
    id serial NOT NULL,
    name character varying NOT NULL,
    date_of_birth date NOT NULL,
    weight double precision NOT NULL,
    image_url character varying,
    species character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Animal_vaccination
(
    id serial NOT NULL,
    animal_id integer NOT NULL,
    vaccine_name character varying NOT NULL,
    doze double precision NOT NULL,
    date date NOT NULL,
    disease character varying NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (animal_id) REFERENCES Animal (id)
);

CREATE TABLE IF NOT EXISTS Animal_shelter
(
    id serial NOT NULL,
    animal_id integer NOT NULL,
    shelter_id integer NOT NULL,
    start_of_residence date NOT NULL,
    end_of_residence date NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (shelter_id) REFERENCES Shelter (id),
    FOREIGN KEY (animal_id) REFERENCES Animal (id)
);

CREATE TABLE IF NOT EXISTS Users
(
    id serial NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    email character varying NOT NULL,
    phone character varying NOT NULL,
    password character varying NOT NULL,
    role character varying NOT NULL,
    shelter_id integer,
    PRIMARY KEY (id)
);
