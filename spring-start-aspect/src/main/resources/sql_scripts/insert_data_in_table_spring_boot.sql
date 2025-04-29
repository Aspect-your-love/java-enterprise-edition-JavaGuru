INSERT INTO company (name)
VALUES ('Yandex'),
       ('Center Klinika'),
       ('Proton'),
       ('Level Design'),
       ('Developer</>Groups');

INSERT INTO company_locales (company_id, lang, description)
VALUES (1, 'ru', 'Digital area club'),
       (2, 'en', 'Medicine'),
       (3, 'hu', 'Science, technology, vibe'),
       (4, 'ru', 'Game design'),
       (5, 'pl', 'Developing, centering, health');

INSERT INTO users (id, username, birth_date, firstname, lastname, role, company_id)
VALUES (1, 'aspect@dev.ru', '2001-11-01', 'Viktor', 'Kulagin', 'DEVELOPER', 5),
       (2, 'kkkk@yandex.ru', '2000-12-1', 'Bb', 'Aaa', 'MANAGER', 5),
       (3, 'tumba@tumbler.com', '1982-10-23', 'Oleg', 'Krylov', 'USER', 2),
       (4, 'aaa@gmail.ru', '1992-01-15', 'Ivan', 'Butin', 'ADMIN', 2),
       (5, 'level@des.ru', '1985-06-24', 'Leva', 'Chertisky', 'USER', 5),
       (6, 'carpe.diem@loma.ru', '1985-06-24', 'Arun', 'Ortiz', 'ADMIN', 4),
       (7, 'fortin@yandex.ru', '2030-06-22', 'Ivan', 'Qu', 'USER', 4),
       (8, 'leha@tempory.ru', '2016-12-09', 'Rekha', 'Ali', 'USER', 3),
       (9, 'figa@test.ru', '1970-09-11', 'Ashok', 'Gomes', 'USER', 3),
       (10, 'geo@geo.com', '1994-08-18', 'Marina', 'Zuo', 'CEO', 1);

INSERT INTO payments (amount, reciever_id)
VALUES (8, 1),
       (292, 1),
       (756, 3),
       (599, 3),
       (837, 6),
       (707, 4),
       (187, 7),
       (12, 7),
       (614, 2),
       (806, 9),
       (321, 10),
       (804, 2),
       (607, 4);

INSERT INTO chats (name)
VALUES ('Aliquamconsequat'),
       ('Primisquis'),
       ('Congueut'),
       ('Ultriciesnon'),
       ('Sodalestempus'),
       ('Felisaliquam'),
       ('Sedullamcorper'),
       ('Exsuscipit'),
       ('Famesnam'),
       ('Hacclass'),
       ('Habitantpulvinar'),
       ('Dignissimtempus'),
       ('Feugiattorquent'),
       ('Diamerat'),
       ('Plateamus');

INSERT INTO users_chat (user_id, chat_id)
VALUES
(3, 11),
(6, 2),
(8, 2),
(9, 11),
(4, 11),
(7, 10),
(6, 4),
(5, 2),
(1, 2),
(1, 9),
(7, 4),
(7, 8),
(5, 5),
(1, 11),
(1, 5),
(5, 1),
(8, 6);

