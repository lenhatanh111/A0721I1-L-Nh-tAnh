create database sales_manage;
use sales_manage;
create table customer(
c_id int primary key auto_increment,
c_name varchar(30),
c_age int
);
create table `order`(
o_id int primary key auto_increment,
c_id int,
foreign key(c_id) references customer(c_id),
o_date date,
o_total_price int

);
create table product(
p_id int primary key auto_increment,
p_name varchar(50),
p_price int
);
create table order_detal(
o_id int,
p_id int,
primary key(o_id,p_id),
foreign key(o_id) references `order`(o_id),
foreign key(p_id) references product(p_id)
);