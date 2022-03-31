CREATE DATABASE `demo`;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER //
create procedure get_user_by_id(in user_id int)
begin
select users.name, users.email , users.country from users where id = user_id;
end//
DELIMITER ;
call get_user_by_id(1);

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;

create table Permision(

id int(11) primary key,

name varchar(50)

);

 

create table User_Permision(

permision_id int(11),

user_id int(11)

);
drop table user_permision;
insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');

DELIMITER //
create procedure view_all_user()
begin select * from users;
end//
DELIMITER ;
call view_all_user();

DELIMITER //
create procedure update_user(in id_user int,in name_user varchar(120), in email_user varchar(220),in country_user varchar(120))
begin update users set `name`= name_user,email=email_user , country =country_user where id = id_user ;
end//
DELIMITER ;
call update_user(1,'xuan','xuan@gmail.com','quang ngai');

DELIMITER //
create procedure delete_user(in id_user int)
begin delete from users where id = id_user;
end//
DELIMITER ;
call view_all_user();
call delete_user(1);
