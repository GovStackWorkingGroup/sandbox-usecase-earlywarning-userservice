--liquibase formatted sql

--changeset vuk:create_permission_table
--preconditions onFail:HALT onError:HALT
CREATE SEQUENCE IF NOT EXISTS perm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS permission_table
(
    id BIGINT NOT NULL DEFAULT nextval('perm_id_seq') PRIMARY KEY,
    permissionUUID     UUID   NOT NULL,
    permissionName    VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    createdBby UUID NOT NULL
);

--changeset vuk:add permission records
--preconditions onFail:HALT onError:HALT
INSERT INTO public.permission_table (permissionUUID, permissionName, createdAt,createdBby )
VALUES ('a4fd27e5-ef0a-4a12-83d6-415a9f3ff422'::uuid, 'Broadcast' , now(), '77705e98-1892-42ec-ad22-2ce12395f678'::uuid),
        ('c9f8df77-2b10-421f-95c6-b745953d1c44'::uuid, 'Read' , now(), '77705e98-1892-42ec-ad22-2ce12395f678'::uuid);

