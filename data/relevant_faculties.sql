create table faculties
(
    id                  int auto_increment
        primary key,
    name                varchar(5)   null,
    information         text         null,
    short_information   varchar(100) null,
    faculty_rating      float        null,
    hostel_rating       float        null,
    studentasset_rating float        null,
    study_rating        float        null,
    campus              varchar(3)   null
);

INSERT INTO relevant.faculties (id, name, information, short_information, faculty_rating, hostel_rating, studentasset_rating, study_rating, campus) VALUES (1, 'ФИТР', 'говно', 'говно', 0, 0, 0, 0, '11б');