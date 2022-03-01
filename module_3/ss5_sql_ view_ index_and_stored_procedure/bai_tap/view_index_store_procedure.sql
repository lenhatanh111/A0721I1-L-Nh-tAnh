create database product_manage;
use product_manage;
create table products (
id int primary key,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);
insert into products values(1,'abc','tivi',5000000,2,'21 ins','new'),
(2,'xyz','tivi',5000000,2,'21 ins','new'),
(3,'acd','tu lanh',4000000,4,'15 lit','new'),
(4,'bdc','may giat',5000000,3,'15 lit','old'),
(5,'zdx','dieu hoa',3000000,2,'inverter','old'),
(6,'qty','robot lau nha',4000000,6,'USA','new'),
(7,'urf','laptop',15000000,7,'asus ','old'),
(8,'ofa','bong den',20000,10,'led','new'),
(9,'std','bep ga',2000000,1,'2 bep','old'); 

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)--
create unique index unique_index_products on products(product_code);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)--
create index composite_index_products on products(product_name,product_price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào--
explain select * from products where product_code =3;
explain select * from products where product_price =5000000;
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.--
create view product_view as select product_code, product_name, product_price, product_status from products;
-- Tiến hành sửa đổi view--
create or replace view product_view as select product_code, product_name, product_price, product_status from products 
where product_status='new';
-- Tiến hành xoá view--
drop view product_view;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product--

DELIMITER //

CREATE procedure find_all_product()

begin
select * from products;
end //
DELIMITER ;

-- Tạo store procedure thêm một sản phẩm mới--
DELIMITER //

CREATE procedure add_product(in id int,p_c varchar(45),p_n varchar(45),p_p int,p_a int, p_d varchar(45), p_s varchar(45))

begin
insert into products value(id,p_c,p_n,p_p,p_a,p_d,p_s);
end //
DELIMITER ;

-- Tạo store procedure sửa thông tin sản phẩm theo id--
DELIMITER //
create procedure update_product(in p_id int,p_c varchar(45),p_n varchar(45),p_p int,p_a int, p_d varchar(45), p_s varchar(45))

begin 
SET SQL_SAFE_UPDATES = 0;
update  products set product_code=p_c ,product_name=p_n ,product_price=p_p , product_amount=p_a , product_description=p_d
, product_status=p_s where id=p_id;
end //
DELIMITER ;

call update_product(2,'ntn','ipad',20000000,5,'13 ins','old');
call find_all_product();
call add_product(10,'ntn','ipad',20000000,5,'13 ins','old');

-- Tạo store procedure xoá sản phẩm theo id--

DELIMITER //
create procedure delete_product_by_id(in p_id int)
begin
delete from products where id=p_id;
end //
DELIMITER ;
 call delete_product_by_id(10);
