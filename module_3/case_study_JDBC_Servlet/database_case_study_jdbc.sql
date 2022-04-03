create database case_study_jdbc;
use case_study_jdbc;
create table `position` (
position_id int primary key auto_increment,
positon_name varchar(45)
);
create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);
create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);
create table `role`(
role_id int primary key auto_increment,
role_name varchar(255)
);
create table `user`(
username varchar(255) primary key,
`password` varchar(255)
);
create table user_role(
role_id int ,
username varchar(255),
foreign key(role_id) references `role`(role_id) on update cascade on delete cascade,
foreign key(username) references `user`(username) on update cascade on delete cascade
);
create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int ,
education_degree_id int,
division_id int,
username varchar(255),
foreign key(position_id) references `position`(position_id) on update cascade on delete cascade,
foreign key(education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
foreign key(division_id) references division(division_id) on update cascade on delete cascade,
foreign key(username) references `user`(username) on update cascade on delete cascade
);
create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);
create table customer(
customer_id int primary key auto_increment,
customer_name varchar(45),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int,
foreign key(customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);
create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);
create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);
create table service(
service_id int primary key auto_increment,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int ,
rent_type_id int ,
service_type_id int ,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
foreign key(rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
foreign key(service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);
create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int ,
customer_id int ,
service_id int,
foreign key(employee_id) references employee(employee_id) on update cascade on delete cascade,
foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade,
foreign key(service_id) references service(service_id) on update cascade on delete cascade
);



create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);

create table contract_detail(
contract_detail_int int primary key auto_increment,
contract_id int ,
attach_service_id int ,
quantity int,
foreign key(contract_id) references contract(contract_id) on update cascade on delete cascade,
foreign key(attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade
);
insert into customer_type(customer_type_name) values
("Dinamond"),
("Platinum"),
("Gold"),
("Silver"),
("Member");
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card,customer_phone ,customer_email ,customer_address, customer_type_id) value
(?,?,?,?,?,?,?,?); 
select * from customer where customer_name like '%anh%';
insert into rent_type(rent_type_name) values
("Year"),("Month"),("Day"),("Hour");
insert into service_type(service_type_name) values
("Villa"),("House"),("Room");
insert into `position`(positon_name) values ("quan ly"),("nhan vien");

insert into education_degree(education_degree_name) values ("Trung cap"),("Cao dang"),("Dai hoc"),("Sau dai hoc");
insert into division(division_name) values ("Sale-Marketing"),("Hanh chinh"),("quan ly"),("phuc vu");
-- insert into `user` values
-- ("annguyen@gmail.com","123123"),
-- ("binhlv@gmail.com","123123"),
-- ("thiyen@gmail.com","123123"),
-- ("toan0404@gmail.com","123123"),
-- ("phatphat@gmail.com","123123"),
-- ("annghi20@gmail.com","123123"),
-- ("nhh0101@gmail.com","123123"),
-- ("donghanguyen@gmail.com","123123"),
-- ("hoangtong@gmail.com","123123"),
-- ("nguyencongdao12@gmail.com","123123");


DELIMITER //
create trigger auto_insert_account
before insert on employee
for each row
begin
insert into `user`(username, password) values (new.employee_email,'123123');
end //
DELIMITER ;
-- DELIMITER //
-- create trigger auto_delete_account
-- before delete on employee
-- for each row
-- begin
-- delete from`user` where old.employee_email =username;
-- end //
-- DELIMITER ;
delete from employee where employee_id=5;
drop trigger create_account;
SET SQL_SAFE_UPDATES = 0;
delete from `user`;



