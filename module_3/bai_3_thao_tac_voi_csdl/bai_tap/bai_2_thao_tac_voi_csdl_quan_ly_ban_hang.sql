use sales_manage;
insert into customer(c_name,c_age) values ('Minh quan','10'),('Ngoc Oanh','20'),('Hong Ha','50');
insert into `order`(c_id,o_date) values('1','2006/3/21'),('2','2006/3/23'),('1','2006/3/16');
insert into product(p_name,p_price) values('May Giat','3'),('Tu lanh','5'),('Dieu Hoa','7'),('Quat','1'),('Bep Dien','2');
insert into order_detal values('1','1','3'),('1','3','7'),('1','4','2'),('2','1','1'),('3','1','8'),
('2','5','4'),('2','3','3');

select `order`.o_id,`order`.o_date,product.p_price from `order`left join `order_detal` on `order`.o_id=order_detal.o_id
left join product on order_detal.p_id=product.p_id;
select customer.c_name,product.p_name from `order` left join customer on customer.c_id=`order`.c_id
left join `order_detal` on `order`.o_id=order_detal.o_id
left join product on order_detal.p_id=product.p_id;
select customer.c_name from customer where customer.c_id not in (select `order`.c_id from `order`);
select `order`.o_id, `order`.o_date,(order_detal.od_qty*product.p_price) as total_price from `order`left join order_detal on `order`.o_id=order_detal.o_id
left join product on product.p_id=order_detal.p_id;
