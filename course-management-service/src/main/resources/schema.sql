create table course
(
   id integer not null,
   name varchar(255) not null,
   category varchar(255) not null,
   created_at timestamp not null,
   updated_at timestamp not null,
   primary key(id)
);

create table course_student{

id integer not null,
student_id integer not null,
course_id integer not null,
created_at timestamp not null,
updated_at timestamp not null,
primary key(id)
}