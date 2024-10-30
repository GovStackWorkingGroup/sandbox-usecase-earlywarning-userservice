--liquibase formatted sql

--changeset vuk:create_user_group_table
--preconditions onFail:HALT onError:HALT
CREATE SEQUENCE IF NOT EXISTS group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS "user_group"
(
    id           BIGINT NOT NULL DEFAULT nextval('group_id_seq') PRIMARY KEY,
    groupUUID     UUID   NOT NULL,
    groupName    VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL,
    createdBby UUID NOT NULL,
    updatedBy  UUID NOT NULL
);

