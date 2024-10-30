--liquibase formatted sql

--changeset vuk:create_user_table
--preconditions onFail:HALT onError:HALT
CREATE SEQUENCE IF NOT EXISTS end_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS "end_user_table"
(
    id                            BIGINT              NOT NULL DEFAULT nextval('end_user_id_seq') PRIMARY KEY,
    endUserUUID                   UUID                NOT NULL,
    fullName                      VARCHAR(255)        NOT NULL,
    email                         VARCHAR(255) UNIQUE NOT NULL,
    contactPhone                  VARCHAR(20)         NOT NULL,
    countryId                     INTEGER             NOT NULL,
    countyId                      INTEGER             NOT NULL,
    defaultLanguageId             INTEGER             NOT NULL,
    defaultCommunicationChannelId INTEGER             NOT NULL
);