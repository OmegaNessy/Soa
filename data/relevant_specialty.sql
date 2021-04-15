create table specialty
(
    ID                int auto_increment
        primary key,
    NAME              varchar(30) null,
    PARENT_ID         int         not null,
    INFORMATION       text        null,
    PASSING_SCORE     int         null,
    FIRST_SUBJECT_ID  int         null,
    SECOND_SUBJECT_ID int         null,
    THIRD_SUBJECT_ID  int         null,
    constraint SPECIALTY_FACULTIES_ID_FK
        foreign key (PARENT_ID) references faculties (id),
    constraint specialty_subjects_id_fk
        foreign key (FIRST_SUBJECT_ID) references subjects (id),
    constraint specialty_subjects_id_fk_2
        foreign key (SECOND_SUBJECT_ID) references subjects (id),
    constraint specialty_subjects_id_fk_3
        foreign key (THIRD_SUBJECT_ID) references subjects (id)
);

INSERT INTO relevant.specialty (ID, NAME, PARENT_ID, INFORMATION, PASSING_SCORE, FIRST_SUBJECT_ID, SECOND_SUBJECT_ID, THIRD_SUBJECT_ID) VALUES (1, 'ПОИТ', 1, 'говно', 340, 1, 2, 4);
INSERT INTO relevant.specialty (ID, NAME, PARENT_ID, INFORMATION, PASSING_SCORE, FIRST_SUBJECT_ID, SECOND_SUBJECT_ID, THIRD_SUBJECT_ID) VALUES (3, 'ПОИТ', 1, 'говно', 340, 1, 2, 4);