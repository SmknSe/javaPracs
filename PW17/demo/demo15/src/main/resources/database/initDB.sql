-- create sequence phone_sequence start 1 increment 1;
-- create sequence manufacture_sequence start 1 increment 1;
-- ALTER SEQUENCE phone_sequence RESTART WITH 1;
-- ALTER SEQUENCE manufacture_sequence RESTART WITH 1;
CREATE TABLE IF NOT EXISTS phones
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    name  VARCHAR(256) NOT NULL ,
    creation_year  INT NOT NULL ,
    manufacture_id INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS manufactures
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    name  VARCHAR(256) NOT NULL ,
    address  VARCHAR(256) NOT NULL
);
-- DROP TABLE IF EXISTS phones;
-- DROP TABLE IF EXISTS manufactures;