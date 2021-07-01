create table course
(
   id integer not null,
   name varchar(255) not null,
   category varchar(255) not null,
   register_at date not null,
   primary key(id)
);

create table course_student{

id integer not null,
student_id integer not null,
course_id integer not null
primary key(id)
}