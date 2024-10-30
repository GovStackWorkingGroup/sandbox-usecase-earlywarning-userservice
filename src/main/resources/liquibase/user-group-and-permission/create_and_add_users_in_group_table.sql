--liquibase formatted sql

--changeset vuk:create_and_add_users_in_user_group_table.
--preconditions onFail:HALT onError:HALT
CREATE TABLE IF NOT EXISTS "users_in_group"
(
    groupUUID     UUID   NOT NULL,
    userUUID     UUID   NOT NULL,
    insertedAt TIMESTAMP NOT NULL,
    insertedBy UUID NOT NULL
);

INSERT INTO public.users_in_group (groupUUID, userUUID, insertedAt, insertedBy)
VALUES ('7d00e1a8-49a0-498a-9b69-01637311ec96'::uuid, '5a2e626c-1222-44a3-b5a2-8cb21167c354'::uuid, now(), 'a3af8add-0665-407e-a4a1-b61c42aacc11'::uuid),
 ('708207cc-0bb3-452b-8faf-9d16800345c1'::uuid, '5a2e626c-1222-44a3-b5a2-8cb21167c354'::uuid, now(), 'a3af8add-0665-407e-a4a1-b61c42aacc11'::uuid),
 ('708207cc-0bb3-452b-8faf-9d16800345c1'::uuid, '19dac117-3242-4331-b0b4-1e4393e083d4'::uuid, now(), 'a3af8add-0665-407e-a4a1-b61c42aacc11'::uuid);


