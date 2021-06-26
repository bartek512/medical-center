INSERT INTO medical_center(id, version, city, postal_code, street, name)
VALUES (1, 1, 'Wroclaw', '43-434', 'Opolska', 'Medicover');

INSERT INTO medical_center(id, version, city, postal_code, street, name)
VALUES (3, 1, 'Wroclaw', '43-434', 'Borowska', 'Przychodnia');

INSERT INTO medical_center(id, version, city, postal_code, street, name)
VALUES (2, 2, 'Wroclaw', '43-123', 'Krakowska', 'Luxmed');


INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (1, 1, 'Wroclaw', '43-123', 'Krakowska', 'andrzej@onet.pl', 'Andrzej', 'Nowak', '123456789', '1990-12-12',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (2, 1, 'Wroclaw', '43-123', 'Krakowska', 'krzysztof@onet.pl', 'Krzysztof', 'Krzysztof', '123456789',
        '1990-12-12',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (3, 1, 'Wroclaw', '43-123', 'Kosciuszki', 'tomek@onet.pl', 'Tomasz', 'Kowalski', '123456789', '1994-12-12',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (4, 1, 'Wroclaw', '43-123', 'Kosciuszki', 'blazej@onet.pl', 'Blazej', 'Blazej', '123456789', '1994-12-12',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (5, 1, 'Wroclaw', '43-123', 'Kosciuszki', 'Michal@onet.pl', 'Michal', 'Blazej', '123456789', '2003-06-19',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (10, 1, 'Wroclaw', '43-123', 'Kosciuszki', 'Michal@onet.pl', 'Grzegorz', 'ggg', '123456789', '2003-06-19',
        'MALE',
        1);

INSERT INTO patient(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                    date_of_birth, sex,
                    medical_center_id)
VALUES (6, 1, 'Wroclaw', '43-123', 'Kosciuszki', 'tomasz@onet.pl', 'Tomasz', 'Tomasz', '123456789', '2003-06-19',
        'MALE',
        1);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (101, 1, 'Wroclaw', '43-123', 'Krakowska', 'andrzej@onet.pl', 'Andrzej', 'Nowak', '123456789',
        100);


INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (102, 1, 'Wroclaw', '43-123', 'Warszawska', 'janusz@onet.pl', 'Janusz', 'Nowak', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (103, 1, 'Wroclaw', '43-123', 'Olawska', 'anna@onet.pl', 'Anna', 'Wanna', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (104, 1, 'Wroclaw', '43-123', 'Olawska', 'michal@onet.pl', 'Michal', 'Wanna', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (105, 1, 'Wroclaw', '43-123', 'Olawska', 'Grzegorz@onet.pl', 'Grzegorz', 'Grzegorz', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (106, 1, 'Wroclaw', '43-123', 'Olawska', 'Andrzej@onet.pl', 'Andrzej', 'Andrzej', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (107, 1, 'Wroclaw', '43-123', 'Olawska', 'krzyszof@onet.pl', 'krzyszof', 'krzysztokrzysztof', '123456789',
        100);

INSERT INTO doctor(id, version, city, postal_code, street, email, first_name, last_name, telephone_number,
                   payment_per_hour)
VALUES (108, 1, 'Wroclaw', '43-123', 'Olawska', 'krzyszof@onet.pl', 'krzyszof', 'krzysztokrzysztof', '123456789',
        100);



INSERT INTO medical_duty(id, version, date, doctor_entity_id, medical_center_id)
VALUES (1, 1, '2021-06-22', 101, 1);

INSERT INTO medical_duty(id, version, date, doctor_entity_id, medical_center_id)
VALUES (2, 1, '2021-06-22', 101, 3);

INSERT INTO specialization(id, version, specialization_name)
VALUES (1, 1, 'GYNECOLOGIST');

INSERT INTO specialization(id, version, specialization_name)
VALUES (2, 1, 'PEDIATRICIAN');

INSERT INTO specialization(id, version, specialization_name)
VALUES (3, 1, 'OCULIST');


-- pierwszy lekarz
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (1, 1, 150, '2020-10-12', 'FINISHED', 101, 1);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (2, 1, 150, '2020-09-12', 'FINISHED', 101, 1);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (3, 1, 150, '2020-12-12', 'FINISHED', 101, 1);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (4, 1, 150, '2021-06-06', 'FINISHED', 101, 1);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (5, 1, 150, '2017-10-12', 'CANCELLED_PATIENT', 101, 2);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (6, 1, 150, '2017-09-12', 'CANCELLED_PATIENT', 101, 2);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (7, 1, 150, '2017-12-12', 'CANCELLED_PATIENT', 101, 2);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (8, 1, 150, '2017-06-06', 'CANCELLED_PATIENT', 101, 2);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (9, 1, 150, '2020-09-12', 'CANCELLED_PATIENT', 101, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (10, 1, 150, '2020-12-12', 'CANCELLED_PATIENT', 101, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (11, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 101, 3);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (12, 1, 150, '2020-10-12', 'CANCELLED_PATIENT', 101, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (13, 1, 150, '2021-09-12', 'CANCELLED_PATIENT', 101, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (14, 1, 150, '2020-12-12', 'CANCELLED_PATIENT', 101, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (15, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 101, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (59, 1, 150, '2021-06-06', 'CANCELLED', 101, 4);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (33, 1, 150, '2021-06-15', 'WAITING', 101, 6);

--  drugi lekarz
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (20, 1, 150, '2020-09-12', 'FINISHED', 102, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (21, 1, 150, '2021-4-11', 'CANCELLED_PATIENT', 102, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (22, 1, 150, '2021-06-06', 'FINISHED', 102, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (55, 1, 150, '2021-06-06', 'FINISHED', 102, 3);

-- trzeci lekarz
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (23, 1, 150, '2020-10-12', 'FINISHED', 103, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (24, 1, 150, '2020-09-12', 'WAITING', 103, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (25, 1, 150, '2020-12-12', 'FINISHED', 103, 4);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (26, 1, 150, '2021-06-06', 'FINISHED', 103, 4);


-- czwarty lekarz
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (27, 1, 150, '2020-09-12', 'FINISHED', 104, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (28, 1, 150, '2021-2-10', 'CANCELLED_PATIENT', 104, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (29, 1, 150, '2021-06-06', 'FINISHED', 104, 3);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (30, 1, 150, '2021-06-06 15:00:00', 'FINISHED', 104, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (31, 1, 150, '2021-06-20 15:00:00', 'FINISHED', 104, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (32, 1, 150, '2021-06-15 15:00:00', 'FINISHED', 104, 3);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (61, 1, 150, '2021-06-16 15:00:00', 'FINISHED', 104, 3);

-- piaty lekarz

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (34, 1, 150, '2022-06-14 15:00:00', 'FINISHED', 105, 3);

-- 6 lekarz

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (35, 1, 150, '2021-06-15 15:00:00', 'FINISHED', 106, 3);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (37, 1, 150, '2021-07-15 15:00:00', 'CANCELLED_PATIENT', 106, 5);

INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (38, 1, 150, '2022-07-10 15:00:00', 'CANCELLED_PATIENT', 106, 6);

--  7 lekarz
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (39, 1, 150, '2022-06-12 15:00:00', 'FINISHED', 107, 3);

-- -- 8 lekarz
--
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (70, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (71, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (72, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (73, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (74, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (75, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (76, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (77, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (78, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (79, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (80, 1, 150, '2021-06-06', 'CANCELLED_PATIENT', 108, 10);
INSERT INTO visit(id, version, price, start_time, visit_status, doctor_id, patient_id)
VALUES (81, 1, 150, '2021-06-06', 'CANCELLED', 108, 10);





INSERT INTO doctor_to_specialization(doctor_id, specialization_id)
VALUES (103, 1);

INSERT INTO doctor_to_specialization(doctor_id, specialization_id)
VALUES (104, 2);

INSERT INTO doctor_to_specialization(doctor_id, specialization_id)
VALUES (101, 3);

INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (1, 101);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (2, 101);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (1, 102);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (2, 102);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (1, 103);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (1, 104);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (1, 105);
INSERT INTO doctor_to_medical_center(medical_center_id, doctor_id)
VALUES (2, 106);