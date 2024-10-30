--liquibase formatted sql

--changeset vuk:create_user_group_permission_table
--preconditions onFail:HALT onError:HALT
CREATE TABLE IF NOT EXISTS "user_group_permission"
(   groupUUID     UUID   NOT NULL,
    permissionUUID     UUID   NOT NULL);

--changeset vuk:add user group and permission records
--preconditions onFail:HALT onError:HALT
INSERT INTO public.user_group_permission (groupUUID, permissionUUID)
VALUES ('7d00e1a8-49a0-498a-9b69-01637311ec96'::uuid, 'a4fd27e5-ef0a-4a12-83d6-415a9f3ff422'::uuid),
     ('7d00e1a8-49a0-498a-9b69-01637311ec96'::uuid, 'c9f8df77-2b10-421f-95c6-b745953d1c44'::uuid),
     ('708207cc-0bb3-452b-8faf-9d16800345c1'::uuid, 'c9f8df77-2b10-421f-95c6-b745953d1c44'::uuid);

