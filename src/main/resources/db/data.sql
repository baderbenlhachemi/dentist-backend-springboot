INSERT INTO roles(name) VALUES('ROLE_SUPER_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_DOCTOR');
INSERT INTO roles(name) VALUES('ROLE_SECRETARY');
INSERT INTO roles(name) VALUES('ROLE_PATIENT');

INSERT INTO `dental_clinic`(`id`, `created_at`, `updated_at`, `address`, `email`, `logo`, `name`, `primary_phone`, `secondary_phone`)
VALUES
    (1, '2022-06-03', '2022-06-03', 'Rabat', 'contact@planet-dentist.ma', 'default.png', 'PlanetDentist', '+212 5 22 33 3432','+212 5 22 33 3432');

INSERT INTO `users`(`type`, `id`, `created_at`, `updated_at`, `address`, `birthday`, `cin`, `email`, `first_name`, `gender`, `last_login_date`, `last_name`, `password`, `phone_number`, `username`, `financial_situation_id`, `dental_clinic_id`)
VALUES
    ('S', 1, '2022-06-03', '2022-06-03', 'Rabat', '1999-09-15', 'AE14', 'admin@planet-dentist.com', 'Achraf', NULL, NULL, 'Karoumi', '$2a$10$HvegR1MNKKyrFJ3fxVYf5ewxVAYTVb/kMY/DzciWBbati5VNWt6be', NULL, 'admin', NULL, 1),
    ('P', 2, '2022-06-03', '2022-06-03', 'Rabat', '2000-05-30', 'AE15', 'patient@planet-dentist.com', 'Aymane', NULL, NULL, 'Tahemmout', '$2a$10$HvegR1MNKKyrFJ3fxVYf5ewxVAYTVb/kMY/DzciWBbati5VNWt6be', NULL, 'patient', NULL, 1);

INSERT INTO `user_roles`(`user_id`, `role_id`) VALUES (1,2);
INSERT INTO `user_roles`(`user_id`, `role_id`) VALUES (1,3);

INSERT INTO `user_roles`(`user_id`, `role_id`) VALUES (2,5);