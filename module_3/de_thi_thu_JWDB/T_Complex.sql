create database t_complex;
use t_complex;
create table `status`(
status_id int primary key auto_increment,
status_name varchar(45)
);
create table `floor`(
floor_id int primary key auto_increment,
floor_number int
);
create table flat_type(
flat_type_id int primary key auto_increment,
flat_type_name varchar(50)
);



create table flat(
flat_id varchar(45) primary key ,
status_id int,
area int,
floor_id int,
flat_type_id int,
cost double,
start_date date,
end_date date,
`description` varchar(45),
foreign key(status_id) references `status`(status_id) on update cascade on delete cascade,
foreign key(floor_id) references floor(floor_id) on update cascade on delete cascade,
foreign key(flat_type_id) references flat_type(flat_type_id) on update cascade on delete cascade

);
drop database  t_complex;
insert into `status`(status_name) values("Trống"),("Hạ Tầng"),("Đầy đủ");
insert into floor(floor_number) values(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15);
insert into flat_type(flat_type_name) values("Văn phòng chia sẻ"),("Văn phòng trọn gói");
insert into flat value("MMB-01-01",1,200,1,1,1000000,"2021-01-12","2022-05-18","san sang");
select * from flat where flat_type_id=1 and start_date >="2021-01-12" and end_date<="2022-05-18" and floor=1;
select * from flat order by area;
select f.flat_id,s.status_name,f.area,fl.floor_number,ft.flat_type_name,f.cost,f.start_date,f.end_date,f.`description` from flat f inner join `status` s on 
	f.status_id=s.status_id inner join `floor` fl on f.floor_id=fl.floor_id inner join flat_type ft on f.flat_type_id=ft.flat_type_id order by area;
    select * from flat where flat_type_id like '%1%' and start_date like '%%' and end_date like '%%' and floor_id like '%1%';
    select status_name from `status` where status_id=1;