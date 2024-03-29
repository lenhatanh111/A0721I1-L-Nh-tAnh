create database furama_sql;
use furama_sql;
create table vi_tri(
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45)
);
create table trinh_do(
ma_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45)
);
create table bo_phan(
ma_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45)
);
create table nhan_vien(
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int ,
ma_trinh_do int,
ma_bo_phan int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri) on update cascade on delete cascade,
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do) on update cascade on delete cascade,
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan) on update cascade on delete cascade
);
create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);
create table khach_hang(
ma_khach_hang int primary key auto_increment,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach) on update cascade on delete cascade
);
create table kieu_thue(
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45)
);
create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue)  on update cascade on delete cascade,
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu) on update cascade on delete cascade
);
create table hop_dong(
ma_hop_dong int primary key auto_increment,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien)  on update cascade on delete cascade,
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang) on update cascade on delete cascade,
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu) on update cascade on delete cascade
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key auto_increment,
so_luong int,
ma_dich_vu_di_kem int,
ma_hop_dong int,

foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem) on update cascade on delete cascade,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong) on update cascade on delete cascade
);


-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.--

insert into vi_tri(ten_vi_tri) values('quan ly'),('nhan vien');
insert into trinh_do(ten_trinh_do) values('trung cap'),('cao dang'),('dai hoc'),('sau dai hoc');
insert into bo_phan(ten_bo_phan) values('sale - marketing'),('hanh chinh'),('phuc vu'),('quan ly');
insert into nhan_vien (ho_ten ,ngay_sinh,so_cmnd ,luong ,sdt ,email ,dia_chi ,ma_vi_tri ,ma_bo_phan ,ma_trinh_do) values
('Nguyen Van An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
('Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','222 Yên Bái, Đà Nẵng',1,2,2),
('Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
('Võ Công Toản','1980-04-04',123231365,17000000	,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
('Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com' ,'Hải Châu, Đà Nẵng',2,1,1),
('Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
('Nguyễn Hữu Hà','1993-01-01',534323231	,8000000, 0941234553 ,'nhh0101@gmail.com','	4 Nguyễn Chí Thanh, Huế',2,3,2),
('Nguyễn Hà Đông','1989-09-03',	234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
('Tòng Hoang','1982-09-03',	256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',	2,4,4),
('Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);

insert into loai_khach(ten_loai_khach) values ('dinamond'),('platinium'),('gold'),('silver'),('member');
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,sdt,email,dia_chi,ma_loai_khach) 
values('Nguyễn Thị Hào',	'1970-11-07',	0	,643431213	,0945423362	,'thihao07@gmail.com',	'23 Nguyễn Hoàng, Đà Nẵng',	5),
('Phạm Xuân Diệu',	'1992-08-08',	1	,865342123,	0954333333	,'xuandieu92@gmail.com	','K77/22 Thái Phiên, Quảng Trị',	3),
('Trương Đình Nghệ',	'1990-02-27',	1,	488645199,	0373213122	,'nghenhan2702@gmail.com',	'K323/12 Ông Ích Khiêm, Vinh',	1),
('Dương Văn Quan',	'1981-07-08',	1	,543432111	,0490039241,'	duongquan@gmail.com',	'K453/12 Lê Lợi, Đà Nẵng',	1),
('Hoàng Trần Nhi Nhi',	'1995-12-09',	0,	795453345,	0312345678,	'nhinhi123@gmail.com',	'224 Lý Thái Tổ, Gia Lai',	4),
('Tôn Nữ Mộc Châu',	'2005-12-06',	0,	732434215,	0988888844	,'tonnuchau@gmail.com','	37 Yên Thế, Đà Nẵng',	4),
('Nguyễn Mỹ Kim','	1984-04-08',	0,	856453123,	0912345698	,'kimcuong84@gmail.com',	'K123/45 Lê Lợi, Hồ Chí Minh',	1),
('Nguyễn Thị Hào',	'1999-04-08',	0	,965656433,	0763212345,'	haohao99@gmail.com	','55 Nguyễn Văn Linh, Kon Tum	',3),
('Trần Đại Danh',	'1994-07-01',	1	,432341235,	0643343433,'	danhhai99@gmail.com',	'24 Lý Thường Kiệt, Quảng Ngãi	',1),
('Nguyễn Tâm Đắc',	'1989-07-01',	1,	344343432	,0987654321	,'dactam@gmail.com',	'22 Ngô Quyền, Đà Nẵng',	2);
insert into kieu_thue(ten_kieu_thue) values('year'),('month'),('day'),('hour');
insert into loai_dich_vu(ten_loai_dich_vu) values('villa'),('house'),('room');
insert into dich_vu(ten_dich_vu ,dien_tich ,chi_phi_thue ,so_nguoi_toi_da ,tieu_chuan_phong ,mo_ta_tien_nghi_khac ,dien_tich_ho_boi ,so_tang ,ma_kieu_thue ,ma_loai_dich_vu ) 
values('Villa Beach Front',	25000,	10000000,	10,'	vip	' ,'Có hồ bơ',	500,	4	,3	,1),
('House Princess 01',	14000,	5000000,	7,	'vip','	Có thêm bếp nướng',	null,	3	,2	,2),
('Room Twin 01',	5000,	1000000,	2,	'normal','	Có tivi',	null,null,	4,	3),
('Villa No Beach Front',	22000,	9000000,	8,'	normal','	Có hồ bơi',	300,	3,	3	,1),
('House Princess 02',	10000,	4000000,	5	,'normal','	Có thêm bếp nướng',	null,	2	,3,	2),
('Room Twin 02',	3000	,900000	,2	,'normal','	Có tivi',	null	,null,	4,	3);

insert into hop_dong values
(1,"2020-12-08","2020-12-08",0,3,1,3),
(2,"2020-07-14","2020-07-21",200000,7,3,1),
(3,"2021-03-15","2021-03-17",50000,3,4,2),
(4,"2021-01-14","2021-01-18",100000,7,5,5),
(5,"2021-07-14","2021-07-15",0,7,2,6),
(6,"2021-06-01","2021-06-03",0,7,7,6),
(7,"2021-09-02","2021-09-05",100000,7,4,4),
(8,"2021-06-17","2021-06-18",150000,3,4,1),
(9,"2020-11-19","2020-11-19",0,3,4,3),
(10,"2021-04-12","2021-04-14",0,10,3,5),
(11,"2021-04-25","2021-04-25",0,2,2,1),
(12,"2021-05-25","2021-05-27",0,7,10,1),
(13,"2021-01-28","2021-04-23",1000000,5,9,4),
(14,"2019-12-12","2021-06-25",2000000,5,7,3),
(15,"2019-12-12","2021-01-28",4000000,5,4,1);

insert into dich_vu_di_kem values
(1,"Karaoke",10000,"giờ","tiện nghi,hiện tại"),
(2,"Thuê xe máy",10000,"chiếc","hỏng 1 xe"),
(3,"Thuê xe đạp",20000,"chiếc","tốt"),
(4,"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng"),
(5,"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng"),
(6,"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng"),
(7,"massage",500000,"giờ","có đào ");

insert into hop_dong_chi_tiet values 
(1,5,4,2),
(2,8,1,2),
(3,15,6,4),
(4,1,1,3),
(5,11,2,3),
(6,1,6,1),
(7,2,2,1),
(8,2,2,12),
(9,3,2,5),
(10,4,6,6),
(11,3,1,8),
(12,9,4,10),
(13,14,6,9),
(14,2,1,14),
(15,1,2,7),
(16,15,6,13),
(17,1,7,12),
(18,5,6,15);

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.--

select nv.ma_nhan_vien ,nv.ho_ten ,nv.ngay_sinh ,nv.so_cmnd ,nv.luong ,nv.sdt ,nv.email ,nv.dia_chi ,vt.ten_vi_tri ,td.ten_trinh_do ,bp.ten_bo_phan from
nhan_vien as nv join vi_tri as vt on nv.ma_vi_tri=vt.ma_vi_tri join trinh_do as td on nv.ma_trinh_do=td.ma_trinh_do join bo_phan as bp on nv.ma_bo_phan=bp.ma_bo_phan
where (nv.ho_ten like 'H%'or nv.ho_ten like 'T%' or nv.ho_ten like 'K%') and char_length(nv.ho_ten)<=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.--

select kh.ho_ten ,kh.ngay_sinh ,kh.gioi_tinh ,kh.so_cmnd ,kh.sdt ,kh.email ,kh.dia_chi ,lk.ten_loai_khach from khach_hang kh join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
where (year(kh.ngay_sinh) between 1972 and 2004) and kh.dia_chi like '%Đà Nẵng' or kh.dia_chi like '%Quảng Trị';

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.--

select kh.ho_ten, count(kh.ma_khach_hang) as so_lan from khach_hang kh join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang join loai_khach lk on 
kh.ma_loai_khach=lk.ma_loai_khach where lk.ten_loai_khach ='dinamond' group by kh.ma_khach_hang order by so_lan;

 -- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng 
 -- và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).--
 
 select kh.ma_khach_hang ,kh.ho_ten ,lk.ten_loai_khach ,hd.ma_hop_dong ,dv.ten_dich_vu , hd.ngay_lam_hop_dong , hd.ngay_ket_thuc , dv.chi_phi_thue+hdct.so_luong*dvdk.gia as tong_tien
 from khach_hang kh left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach left join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang left join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu
 left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem= dvdk.ma_dich_vu_di_kem group by kh.ma_khach_hang;
 
 -- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).--
 
 select dv.ma_dich_vu, dv.ten_dich_vu , dv.dien_tich ,dv.chi_phi_thue , ldv.ten_loai_dich_vu from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu join hop_dong hd on hd.ma_dich_vu=dv.ma_dich_vu
where dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv  join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu  join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu where month(hd.ngay_lam_hop_dong)<=3 
and year(hd.ngay_lam_hop_dong)=2021) group by dv.ma_dich_vu ;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.--

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu where year(hd.ngay_lam_hop_dong)=2020 and dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong)=2021) group by dv.ma_dich_vu;

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.--
-- cach 1:
select kh.ho_ten from khach_hang kh group by kh.ho_ten;
-- cach 2:
select kh.ho_ten from khach_hang kh  group by kh.ma_khach_hang having count(kh.ho_ten)=1;
-- cach 3:
select kh.ho_ten from khach_hang kh left join hop_dong hd on kh.ma_khach_hang= hd.ma_khach_hang group by kh.ho_ten;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.--

select month(hd.ngay_lam_hop_dong) as thang ,year(hd.ngay_lam_hop_dong) as nam , count(kh.ma_khach_hang) as so_luong from hop_dong hd join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang
group by thang order by nam, thang;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong,
-- ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem 
from hop_dong hd join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong group by hd.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, kh.ho_ten, kh.dia_chi from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem join hop_dong hd 
on hdct.ma_hop_dong= hd.ma_hop_dong join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang join loai_khach lk on 
kh.ma_loai_khach=lk.ma_loai_khach where lk.ten_loai_khach='dinamond' and  kh.dia_chi like concat('%',convert('Quảng Ngãi',binary),'%') or kh.dia_chi like '% vinh' group by kh.ma_khach_hang, dvdk.ten_dich_vu_di_kem;

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hd.ma_hop_dong, nv.ho_ten ,kh.ho_ten , kh.sdt, dv.ten_dich_vu, sum(hdct.so_luong) as so_luong_dich_vu_di_kem ,hd.tien_dat_coc
from hop_dong hd join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong join nhan_vien nv on hd.ma_nhan_vien=nv.ma_nhan_vien
 join khach_hang kh on kh.ma_khach_hang=hd.ma_khach_hang  join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu where month(hd.ngay_lam_hop_dong)>9 
 and year(hd.ngay_lam_hop_dong)=2020 and kh.ma_khach_hang not in (select kh.ma_khach_hang from khach_hang kh join hop_dong hd on
 kh.ma_khach_hang=hd.ma_khach_hang join dich_vu dv on dv.ma_dich_vu =hd.ma_dich_vu where month(hd.ngay_lam_hop_dong)<=6
 and year(hd.ngay_lam_hop_dong)=2021)
 group by hd.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.ma_dich_vu_di_kem , dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem from hop_dong_chi_tiet hdct join
dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem group by hdct.ma_dich_vu_di_kem having 
so_luong_dich_vu_di_kem>= all(select sum(hdct.so_luong) as so_luong_dich_vu_di_kem  from hop_dong_chi_tiet hdct join
dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem group by hdct.ma_dich_vu_di_kem);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, 
-- ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_hop_dong) as so_lan_su_dung from
hop_dong hd join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu join hop_dong_chi_tiet hdct on hdct.ma_hop_dong= hd.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu 
group by dvdk.ma_dich_vu_di_kem having so_lan_su_dung=1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi, count(hd.ma_hop_dong) 
as so_hop_dong_da_lap from nhan_vien nv join trinh_do td on nv.ma_trinh_do=td.ma_trinh_do join bo_phan bp 
on bp.ma_bo_phan=nv.ma_bo_phan join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien where year(hd.ngay_lam_hop_dong) between 2020 and 2021
group by hd.ma_nhan_vien having so_hop_dong_da_lap <=3 ;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021 .	
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien nv  where nv.ma_nhan_vien not in (select hd.ma_nhan_vien from hop_dong hd 
where year(hd.ngay_lam_hop_dong) between 2019 and 2021);

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng 
-- với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

SET SQL_SAFE_UPDATES = 0;
update  khach_hang kh set kh.ma_loai_khach=1 where kh.ma_khach_hang in (select hd.ma_khach_hang from hop_dong hd  join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem where dv.chi_phi_thue+hdct.so_luong*dvdk.gia >10000000 group by hd.ma_khach_hang );

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
delete from hop_dong_chi_tiet hdct where hdct.ma_hop_dong in(select hd.ma_hop_dong from hop_dong hd where year(hd.ngay_lam_hop_dong)<2021);
delete from hop_dong hd where year(hd.ngay_lam_hop_dong)<2021;
delete from khach_hang kh where kh.ma_khach_hang not in (select hd.ma_khach_hang from hop_dong hd group by hd.ma_hop_dong);

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
SET SQL_SAFE_UPDATES = 0;
update dich_vu_di_kem dvdk set dvdk.gia=(dvdk.gia*2) where dvdk.ma_dich_vu_di_kem in
(select ma_dich_vu_di_kem from hop_dong_chi_tiet  group by ma_dich_vu_di_kem having sum(so_luong)>10);

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

select ma_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi from nhan_vien 
union all
select ma_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi from khach_hang ;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

create view v_nhan_vien as
select * from nhan_vien nv where nv.dia_chi like '%Hải Châu%' and nv.ma_nhan_vien in 
(select hd.ma_nhan_vien from hop_dong hd where hd.ngay_lam_hop_dong='2019-12-12');

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien set dia_chi='Liên Chiểu';

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

DELIMITER //
create procedure sp_xoa_khach_hang (in id int)
begin
delete from khach_hang kh where kh.ma_khach_hang=id;
end //
DELIMITER ;

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

DELIMITER //
create procedure sp_them_moi_hop_dong 
(in id int, ngay_lam_hop_dong datetime, ngay_ket_thuc datetime, tien_dat_coc double, ma_nhan_vien int, ma_khach_hang int ,ma_dich_vu int)
begin 
if id in (select ma_hop_dong from hop_dong)
then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'trung ma_hop_dong', MYSQL_ERRNO = 1001; 
elseif ma_nhan_vien not in (select ma_nhan_vien from nhan_vien)
      then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'khong ton tai ma_nhan_vien', MYSQL_ERRNO = 1002;
elseif ma_khach_hang not in (select ma_khach_hang from khach_hang)
then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'khong ton tai ma_khach_hang', MYSQL_ERRNO = 1003;
elseif ma_dich_vu not in (select ma_dich_vu from dich_vu)
      then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'khong ton tai ma_dich_vu', MYSQL_ERRNO = 1004;
else 
insert into hop_dong value (id, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu);
end if;
end //
DELIMITER ;
call sp_them_moi_hop_dong(19,"2020-07-14","2020-07-21",200000,10,3,1);

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

set @sl =0;
DELIMITER //
create trigger tr_xoa_hop_dong after delete on hop_dong
for each row
begin
set @sl= (select count(*) from hop_dong);
end //
DELIMITER ;
select @sl;
delete from hop_dong where ma_hop_dong=2; 

 -- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không,
 -- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
 -- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.

DELIMITER //
create trigger tr_cap_nhat_hop_dong before update on hop_dong
for each row
begin
if year(ngay_lam_hop_dong) = year(ngay_ket_thuc) then
 if month(ngay_lam_hop_dong)> month(ngay_ket_thuc) 
  then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày', MYSQL_ERRNO = 1005;
      end if;
	elseif month(ngay_lam_hop_dong)= month(ngay_ket_thuc) then
          if day(ngay_lam_hop_dong) > day(ngay_ket_thuc) or day(ngay_ket_thuc)-day(ngay_lam_hop_dong)<2
          then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày', MYSQL_ERRNO = 1005;
      end if;
elseif year(ngay_lam_hop_dong) > year(ngay_ket_thuc)
then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày', MYSQL_ERRNO = 1005;
      end if;

end //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
update hop_dong  set ngay_lam_hop_dong='2022-03-15' where ma_hop_dong=3;