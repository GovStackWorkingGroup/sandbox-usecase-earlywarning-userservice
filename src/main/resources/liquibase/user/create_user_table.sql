--liquibase formatted sql

--changeset vuk:create_user_table
--preconditions onFail:HALT onError:HALT
CREATE SEQUENCE IF NOT EXISTS user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS "user_table"
(
    id           BIGINT              NOT NULL DEFAULT nextval('user_id_seq') PRIMARY KEY,
    userUUID     UUID                NOT NULL,
    firstName    VARCHAR(255)        NOT NULL,
    lastName     VARCHAR(255)        NOT NULL,
    email        VARCHAR(255) UNIQUE NOT NULL,
    password     VARCHAR(255)        NOT NULL,
    contactPhone VARCHAR(20)         NOT NULL,
    countryId    INTEGER             NOT NULL
);