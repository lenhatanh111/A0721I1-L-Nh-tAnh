create database `my_database`;
drop database `my_database`;
create database `student_management`;
use student_management;
create table student(
id int,
name varchar(45),
age int,
country varchar(45),
primary key(id)
);
select * from student;
drop table student;
create table class(
id int,
`name` varchar(45),
primary key(id)
);
select * from class;
create table teacher(
id int,
`name`  varchar(45),
age int,
country varchar(45),
primary key(id)
);
select * from teacher;