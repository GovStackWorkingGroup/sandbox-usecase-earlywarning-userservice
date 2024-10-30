--liquibase formatted sql

--changeset vuk:add_user_groups
--preconditions onFail:HALT onError:HALT
INSERT INTO public.user_group
(groupuuid, groupname, createdat, updatedat, createdbby, updatedby)
VALUES('7d00e1a8-49a0-498a-9b69-01637311ec96'::uuid, 'Broadcast group', 'NOW()', 'NOW()', '1aab2494-e368-4be5-9142-7985ef02d937'::uuid, '1aab2494-e368-4be5-9142-7985ef02d937'::uuid),
('708207cc-0bb3-452b-8faf-9d16800345c1'::uuid, 'Default group', 'NOW()', 'NOW()', '1aab2494-e368-4be5-9142-7985ef02d937'::uuid, '1aab2494-e368-4be5-9142-7985ef02d937'::uuid)

;
