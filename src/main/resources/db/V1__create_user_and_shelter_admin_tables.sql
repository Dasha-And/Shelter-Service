CREATE TABLE IF NOT EXISTS Users
(
    id serial PRIMARY KEY,
    username character varying NOT NULL,
    password character varying NOT NULL,
    role character varying NOT NULL,
    shelter_id int
);
