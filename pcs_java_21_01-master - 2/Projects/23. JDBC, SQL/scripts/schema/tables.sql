create table student
(
    id         serial primary key,
    birth_date timestamp
);

create table course
(
    id         serial primary key,
    start_date timestamp,
    price      integer
);

create table student_course
(
    student_id integer,
    course_id  integer,
    foreign key (student_id) references student (id),
    foreign key (course_id) references course (id)
);

create table lesson
(
    id          serial primary key,
    day         varchar(10),
    start_time  timestamp,
    finish_time timestamp,
    course_id   integer,
    foreign key (course_id) references course (id)
);