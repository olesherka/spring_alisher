drop table if exists students;
drop table if exists teachers;
drop table if exists discipline;
drop table if exists events;
drop table if exists schedule;

CREATE TABLE events(
   event_id   INT PRIMARY KEY,
   event_name varchar(20),
   teacher_id INT,
   student_id INT
);

CREATE TABLE students(
    student_id INT PRIMARY KEY,
    student_name VARCHAR(20),
    student_lname VARCHAR(20),
    event_id INT REFERENCES events(event_id)
);

CREATE TABLE teachers(
     teacher_id INT PRIMARY KEY,
     teacher_name VARCHAR(20),
     teacher_lname VARCHAR(20),
     event_id INT REFERENCES events(event_id)
);

CREATE TABLE discipline(
    discipline_id INT PRIMARY KEY,
    discipline_name varchar(20)
);



CREATE TABLE schedule
(
    schedule_id   INT PRIMARY KEY,
    event_id      int,
    teacher_id    int,
    student_id   int,
    discipline_name varchar(20)
);