-- create sequence phone_sequence start 1 increment 1;
-- create sequence manufacture_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS phones
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    name  VARCHAR(256) NOT NULL ,
    creationYear  INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS manufactures
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    name  VARCHAR(256) NOT NULL ,
    address  VARCHAR(256) NOT NULL
);