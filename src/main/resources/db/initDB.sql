DROP TABLE IF EXISTS sold_trips;
DROP TABLE IF EXISTS guides;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS trips;


CREATE TABLE clients
(
    id               SERIAL PRIMARY KEY                NOT NULL,
    name             VARCHAR(30)                       NOT NULL,
    surname          VARCHAR(30)                       NOT NULL,
    passport         VARCHAR(30)                       NOT NULL

);

CREATE UNIQUE INDEX users_unique_passport_idx ON clients (passport);

CREATE TABLE guides
(
    id              SERIAL PRIMARY KEY                 NOT NULL,
    name            VARCHAR(30)                        NOT NULL,
    surname         VARCHAR(30)                        NOT NULL,
    description     VARCHAR(15)                        NOT NULL
);

CREATE TABLE trips
(
    id                  SERIAL PRIMARY KEY               NOT NULL,
    guide_id             SERIAL                          NOT NULL,
    travel_direction     VARCHAR                         NOT NULL,
    price                INT                             NOT NULL,

    FOREIGN KEY (guide_id) REFERENCES guides (id) ON DELETE CASCADE

);

CREATE TABLE sold_trips
(
     id                   SERIAL PRIMARY KEY                  NOT NULL,
     client_id            SERIAL                              NOT NULL,
     trip_id              SERIAL                              NOT NULL,
     departure_date       DATE                                NOT NULL,
     arrival_date         DATE                                NOT NULL,
     payed                INT                                 NOT NULL,
     goal                 VARCHAR                             NOT NULL,


     FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE,
     FOREIGN KEY (trip_id)   REFERENCES trips (id)   ON DELETE CASCADE
);
