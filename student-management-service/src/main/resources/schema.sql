create table student
(
   id integer not null,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   email varchar(255) not null,
   age integer not null,
   gender integer not null,
   register_at date not null,
   primary key(id)
);