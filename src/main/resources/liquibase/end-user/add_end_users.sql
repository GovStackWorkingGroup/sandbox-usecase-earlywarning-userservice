--liquibase formatted sql

--changeset vuk:add_end_users
--preconditions onFail:HALT onError:HALT
INSERT INTO public."end_user_table"
(endUserUUID, fullname, email, contactphone, countryid, countyId, defaultLanguageId, defaultCommunicationChannelId)
VALUES('5a2e626c-1222-44a3-b5a2-8cb21167c354'::uuid, 'End User 1', 'enduser1@test.com','123456',1,1, 1, 1),
('52ccd487-697f-4b87-b5df-b38937787d54'::uuid, 'End User 2', 'enduser2@test.com', '123456',2,2, 2,1),
('74447c2c-9315-4511-814e-02609b0d7ebf'::uuid, 'End User 3', 'enduser3@test.com', '123456',3,3, 3,1),
('51f4410a-4e03-4ce4-ae44-c6ffc71ef72f'::uuid, 'End User 4', 'enduser4@test.com', '123456',2,1, 1,1),
('7f56f0af-61ea-47d4-b212-568a0f27df52'::uuid, 'End User 5', 'enduser5@test.com', '123456',1,2, 1,1),
('0879663f-fb1c-4317-a32b-a9ff4f2e7b3c'::uuid, 'End User 6', 'enduser6@test.com', '123456',4,3, 4,1),
('fd225c33-5146-4fd5-b291-087029776e6c'::uuid, 'End User 7', 'enduser7@test.com', '123456',1,1, 2,1),
('803c1872-b111-42c9-a3ce-de9eabb4935d'::uuid, 'End User 8', 'enduser8@test.com', '123456',1,2, 2,1),
('33f2561b-5430-4ea1-83a4-76fc818a8fbb'::uuid, 'End User 9', 'enduser9@test.com', '123456',1,3, 2,1),
('f1c5ed21-b931-4c6b-95b0-bfd1c59afb59'::uuid, 'End User 10', 'enduser10@test.com', '123456',1,1, 2,1);