--liquibase formatted sql

--changeset vuk:add_users
--preconditions onFail:HALT onError:HALT
INSERT INTO public."user_table"
(useruuid, firstname, lastname, email, "password", contactphone, countryid)
VALUES('5a2e626c-1222-44a3-b5a2-8cb21167c354'::uuid, 'First', 'User', 'firstUser@test.com', 'asdf1234','123456',1),
('19dac117-3242-4331-b0b4-1e4393e083d4'::uuid, 'Second', 'User', 'secondUser@test.com', 'test1234', '123456',2);