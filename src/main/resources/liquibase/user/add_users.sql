--liquibase formatted sql

--changeset vuk:add_users
--preconditions onFail:HALT onError:HALT
INSERT INTO public."user_table"
(useruuid, firstname, lastname, email, "password", contactphone, countryid)
VALUES('5a2e626c-1222-44a3-b5a2-8cb21167c354'::uuid, 'First', 'User', 'firstUser@test.com', '$2b$12$jad9LFQLlVOu.CB4kAqwH.bSsaVuMAuhO1B21FHWLaMsBiupa6qE.','123456',1),
('19dac117-3242-4331-b0b4-1e4393e083d4'::uuid, 'Second', 'User', 'secondUser@test.com', '$2b$12$CehrvUrS0.5b4qCLq9UaNe9JBbrfplbx1vS4xMUHJGYATDl1ZX6Q6', '123456',2);