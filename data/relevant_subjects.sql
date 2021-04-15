create table subjects
(
    id   int auto_increment
        primary key,
    name varchar(25) not null
);

INSERT INTO relevant.subjects (id, name) VALUES (1, 'Математика');
INSERT INTO relevant.subjects (id, name) VALUES (2, 'Физика');
INSERT INTO relevant.subjects (id, name) VALUES (3, 'Химия');
INSERT INTO relevant.subjects (id, name) VALUES (4, 'Русский язык');
INSERT INTO relevant.subjects (id, name) VALUES (5, 'Английский язык');
INSERT INTO relevant.subjects (id, name) VALUES (6, 'Биология');
INSERT INTO relevant.subjects (id, name) VALUES (7, 'Обществоведение');
INSERT INTO relevant.subjects (id, name) VALUES (8, 'История');