use quan_ly_ban_hang;
insert into customer(c_name,c_age) values ('Minh Quan',10),('Ngoc Oanh',20),('Hong Ha',50);
insert into `order`(c_id,o_date,o_total_price) values(1,'2006-3-21',null), (2,'2006-3-23',null),(1,'2006-3-16',null);
insert into product(p_name,p_price) values ('may giat',3),('tu lanh',5),('dieu hoa',7),('quat',1),('bep dien',2);
insert into order_detail values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order --
select o_id,o_date,o_total_price from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách --
select c.c_name,p.p_name from customer as c join `order` as o on c.c_id=o.c_id join order_detail as od on o.o_id=od.o_id join product as p on od.p_id=p.p_id ; 
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào--
select c.c_name from customer as c where c.c_id not in (select o.c_id from `order` as o);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)--
select o.o_id, o.o_date, sum(od_qty*p_price) as tong_tien from `order` as o join `order_detail` as od_dt on o.o_id=od_dt.o_id join product as p on p.p_id=od_dt.p_id group by o_id;