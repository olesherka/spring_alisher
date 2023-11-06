drop table if exists students;
drop table if exists teachers;
drop table if exists discipline;
drop table if exists events;
drop table if exists schedule_of_events;

CREATE TABLE students(
    student_id INT PRIMARY KEY,
    student_name VARCHAR(20),
    student_lname VARCHAR(20)
);

CREATE TABLE teachers(
     teacher_id INT PRIMARY KEY,
     teacher_name VARCHAR(20),
     teacher_lname VARCHAR(20)
);

CREATE TABLE discipline(
    discipline_id INT PRIMARY KEY,
    discipline_name varchar(20)
);

CREATE TABLE events(
    event_id   INT PRIMARY KEY,
    event_name varchar(20),
    event_date date,
    teacher_id int,
    student_id int
);

CREATE TABLE schedule_of_events
(
    schedule_id   INT PRIMARY KEY,
    event_id      date,
    teacher_id    int,
    students_id   int,
    discipline_id int
);