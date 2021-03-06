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


-- 1.	Th??m m???i th??ng tin cho t???t c??? c??c b???ng c?? trong CSDL ????? c?? th??? tho??? m??n c??c y??u c???u b??n d?????i.--

insert into vi_tri(ten_vi_tri) values('quan ly'),('nhan vien');
insert into trinh_do(ten_trinh_do) values('trung cap'),('cao dang'),('dai hoc'),('sau dai hoc');
insert into bo_phan(ten_bo_phan) values('sale - marketing'),('hanh chinh'),('phuc vu'),('quan ly');
insert into nhan_vien (ho_ten ,ngay_sinh,so_cmnd ,luong ,sdt ,email ,dia_chi ,ma_vi_tri ,ma_bo_phan ,ma_trinh_do) values
('Nguyen Van An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
('L?? V??n B??nh','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','222 Y??n B??i, ???? N???ng',1,2,2),
('H??? Th??? Y???n','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',1,3,2),
('V?? C??ng To???n','1980-04-04',123231365,17000000	,0374443232,'toan0404@gmail.com','77 Ho??ng Di???u, Qu???ng Tr???',1,4,4),
('Nguy???n B???nh Ph??t','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com' ,'H???i Ch??u, ???? N???ng',2,1,1),
('Kh??c Nguy???n An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguy???n T???t Th??nh, ???? N???ng',2,2,3),
('Nguy???n H???u H??','1993-01-01',534323231	,8000000, 0941234553 ,'nhh0101@gmail.com','	4 Nguy???n Ch?? Thanh, Hu???',2,3,2),
('Nguy???n H?? ????ng','1989-09-03',	234414123,9000000,0642123111,'donghanguyen@gmail.com','111 H??ng V????ng, H?? N???i',2,4,4),
('T??ng Hoang','1982-09-03',	256781231,6000000,0245144444,'hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',	2,4,4),
('Nguy???n C??ng ?????o','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Ho?? Kh??nh, ?????ng Nai',2,3,2);

insert into loai_khach(ten_loai_khach) values ('dinamond'),('platinium'),('gold'),('silver'),('member');
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,sdt,email,dia_chi,ma_loai_khach) 
values('Nguy???n Th??? H??o',	'1970-11-07',	0	,643431213	,0945423362	,'thihao07@gmail.com',	'23 Nguy???n Ho??ng, ???? N???ng',	5),
('Ph???m Xu??n Di???u',	'1992-08-08',	1	,865342123,	0954333333	,'xuandieu92@gmail.com	','K77/22 Th??i Phi??n, Qu???ng Tr???',	3),
('Tr????ng ????nh Ngh???',	'1990-02-27',	1,	488645199,	0373213122	,'nghenhan2702@gmail.com',	'K323/12 ??ng ??ch Khi??m, Vinh',	1),
('D????ng V??n Quan',	'1981-07-08',	1	,543432111	,0490039241,'	duongquan@gmail.com',	'K453/12 L?? L???i, ???? N???ng',	1),
('Ho??ng Tr???n Nhi Nhi',	'1995-12-09',	0,	795453345,	0312345678,	'nhinhi123@gmail.com',	'224 L?? Th??i T???, Gia Lai',	4),
('T??n N??? M???c Ch??u',	'2005-12-06',	0,	732434215,	0988888844	,'tonnuchau@gmail.com','	37 Y??n Th???, ???? N???ng',	4),
('Nguy???n M??? Kim','	1984-04-08',	0,	856453123,	0912345698	,'kimcuong84@gmail.com',	'K123/45 L?? L???i, H??? Ch?? Minh',	1),
('Nguy???n Th??? H??o',	'1999-04-08',	0	,965656433,	0763212345,'	haohao99@gmail.com	','55 Nguy???n V??n Linh, Kon Tum	',3),
('Tr???n ?????i Danh',	'1994-07-01',	1	,432341235,	0643343433,'	danhhai99@gmail.com',	'24 L?? Th?????ng Ki???t, Qu???ng Ng??i	',1),
('Nguy???n T??m ?????c',	'1989-07-01',	1,	344343432	,0987654321	,'dactam@gmail.com',	'22 Ng?? Quy???n, ???? N???ng',	2);
insert into kieu_thue(ten_kieu_thue) values('year'),('month'),('day'),('hour');
insert into loai_dich_vu(ten_loai_dich_vu) values('villa'),('house'),('room');
insert into dich_vu(ten_dich_vu ,dien_tich ,chi_phi_thue ,so_nguoi_toi_da ,tieu_chuan_phong ,mo_ta_tien_nghi_khac ,dien_tich_ho_boi ,so_tang ,ma_kieu_thue ,ma_loai_dich_vu ) 
values('Villa Beach Front',	25000,	10000000,	10,'	vip	' ,'C?? h??? b??',	500,	4	,3	,1),
('House Princess 01',	14000,	5000000,	7,	'vip','	C?? th??m b???p n?????ng',	null,	3	,2	,2),
('Room Twin 01',	5000,	1000000,	2,	'normal','	C?? tivi',	null,null,	4,	3),
('Villa No Beach Front',	22000,	9000000,	8,'	normal','	C?? h??? b??i',	300,	3,	3	,1),
('House Princess 02',	10000,	4000000,	5	,'normal','	C?? th??m b???p n?????ng',	null,	2	,3,	2),
('Room Twin 02',	3000	,900000	,2	,'normal','	C?? tivi',	null	,null,	4,	3);

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
(1,"Karaoke",10000,"gi???","ti???n nghi,hi???n t???i"),
(2,"Thu?? xe m??y",10000,"chi???c","h???ng 1 xe"),
(3,"Thu?? xe ?????p",20000,"chi???c","t???t"),
(4,"Buffet bu???i s??ng",15000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
(5,"Buffet bu???i tr??a",90000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
(6,"Buffet bu???i t???i",16000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
(7,"massage",500000,"gi???","c?? ????o ");

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

-- 2.	Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.--

select nv.ma_nhan_vien ,nv.ho_ten ,nv.ngay_sinh ,nv.so_cmnd ,nv.luong ,nv.sdt ,nv.email ,nv.dia_chi ,vt.ten_vi_tri ,td.ten_trinh_do ,bp.ten_bo_phan from
nhan_vien as nv join vi_tri as vt on nv.ma_vi_tri=vt.ma_vi_tri join trinh_do as td on nv.ma_trinh_do=td.ma_trinh_do join bo_phan as bp on nv.ma_bo_phan=bp.ma_bo_phan
where (nv.ho_ten like 'H%'or nv.ho_ten like 'T%' or nv.ho_ten like 'K%') and char_length(nv.ho_ten)<=15;

-- 3.	Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.--

select kh.ho_ten ,kh.ngay_sinh ,kh.gioi_tinh ,kh.so_cmnd ,kh.sdt ,kh.email ,kh.dia_chi ,lk.ten_loai_khach from khach_hang kh join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
where (year(kh.ngay_sinh) between 1972 and 2004) and kh.dia_chi like '%???? N???ng' or kh.dia_chi like '%Qu???ng Tr???';

-- 4.	?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.--

select kh.ho_ten, count(kh.ma_khach_hang) as so_lan from khach_hang kh join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang join loai_khach lk on 
kh.ma_loai_khach=lk.ma_loai_khach where lk.ten_loai_khach ='dinamond' group by kh.ma_khach_hang order by so_lan;

 -- 5.	Hi???n th??? ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (V???i t???ng ti???n ???????c t??nh theo c??ng th???c nh?? sau: Chi Ph?? Thu?? + S??? L?????ng * Gi??, v???i S??? L?????ng 
 -- v?? Gi?? l?? t??? b???ng dich_vu_di_kem, hop_dong_chi_tiet) cho t???t c??? c??c kh??ch h??ng ???? t???ng ?????t ph??ng. (nh???ng kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra).--
 
 select kh.ma_khach_hang ,kh.ho_ten ,lk.ten_loai_khach ,hd.ma_hop_dong ,dv.ten_dich_vu , hd.ngay_lam_hop_dong , hd.ngay_ket_thuc , dv.chi_phi_thue+hdct.so_luong*dvdk.gia as tong_tien
 from khach_hang kh left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach left join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang left join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu
 left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem= dvdk.ma_dich_vu_di_kem group by kh.ma_khach_hang;
 
 -- 6.	Hi???n th??? ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu c???a t???t c??? c??c lo???i d???ch v??? ch??a t???ng ???????c kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2021 (Qu?? 1 l?? th??ng 1, 2, 3).--
 
 select dv.ma_dich_vu, dv.ten_dich_vu , dv.dien_tich ,dv.chi_phi_thue , ldv.ten_loai_dich_vu from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu join hop_dong hd on hd.ma_dich_vu=dv.ma_dich_vu
where dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv  join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu  join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu where month(hd.ngay_lam_hop_dong)<=3 
and year(hd.ngay_lam_hop_dong)=2021) group by dv.ma_dich_vu ;

-- 7.	Hi???n th??? th??ng tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu c???a t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2020 nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2021.--

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu where year(hd.ngay_lam_hop_dong)=2020 and dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu=hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong)=2021) group by dv.ma_dich_vu;

-- 8.	Hi???n th??? th??ng tin ho_ten kh??ch h??ng c?? trong h??? th???ng, v???i y??u c???u ho_ten kh??ng tr??ng nhau.--
-- cach 1:
select kh.ho_ten from khach_hang kh group by kh.ho_ten;
-- cach 2:
select kh.ho_ten from khach_hang kh  group by kh.ma_khach_hang having count(kh.ho_ten)=1;
-- cach 3:
select kh.ho_ten from khach_hang kh left join hop_dong hd on kh.ma_khach_hang= hd.ma_khach_hang group by kh.ho_ten;

-- 9.	Th???c hi???n th???ng k?? doanh thu theo th??ng, ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2021 th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.--

select month(hd.ngay_lam_hop_dong) as thang ,year(hd.ngay_lam_hop_dong) as nam , count(kh.ma_khach_hang) as so_luong from hop_dong hd join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang
group by thang order by nam, thang;

-- 10.	Hi???n th??? th??ng tin t????ng ???ng v???i t???ng h???p ?????ng th?? ???? s??? d???ng bao nhi??u d???ch v??? ??i k??m. K???t qu??? hi???n th??? bao g???m ma_hop_dong, ngay_lam_hop_dong,
-- ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem).

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem 
from hop_dong hd join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong group by hd.ma_hop_dong;

-- 11.	Hi???n th??? th??ng tin c??c d???ch v??? ??i k??m ???? ???????c s??? d???ng b???i nh???ng kh??ch h??ng c?? ten_loai_khach l?? ???Diamond??? v?? c?? dia_chi ??? ???Vinh??? ho???c ???Qu???ng Ng??i???.

select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, kh.ho_ten, kh.dia_chi from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem join hop_dong hd 
on hdct.ma_hop_dong= hd.ma_hop_dong join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang join loai_khach lk on 
kh.ma_loai_khach=lk.ma_loai_khach where lk.ten_loai_khach='dinamond' and  kh.dia_chi like concat('%',convert('Qu???ng Ng??i',binary),'%') or kh.dia_chi like '% vinh' group by kh.ma_khach_hang, dvdk.ten_dich_vu_di_kem;

-- 12.	Hi???n th??? th??ng tin ma_hop_dong, ho_ten (nh??n vi??n), ho_ten (kh??ch h??ng), so_dien_thoai (kh??ch h??ng), ten_dich_vu, so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem),
-- tien_dat_coc c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2020 nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2021.

select hd.ma_hop_dong, nv.ho_ten ,kh.ho_ten , kh.sdt, dv.ten_dich_vu, sum(hdct.so_luong) as so_luong_dich_vu_di_kem ,hd.tien_dat_coc
from hop_dong hd join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong join nhan_vien nv on hd.ma_nhan_vien=nv.ma_nhan_vien
 join khach_hang kh on kh.ma_khach_hang=hd.ma_khach_hang  join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu where month(hd.ngay_lam_hop_dong)>9 
 and year(hd.ngay_lam_hop_dong)=2020 and kh.ma_khach_hang not in (select kh.ma_khach_hang from khach_hang kh join hop_dong hd on
 kh.ma_khach_hang=hd.ma_khach_hang join dich_vu dv on dv.ma_dich_vu =hd.ma_dich_vu where month(hd.ngay_lam_hop_dong)<=6
 and year(hd.ngay_lam_hop_dong)=2021)
 group by hd.ma_hop_dong;

-- 13.	Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???????c s??? d???ng nhi???u nh???t b???i c??c Kh??ch h??ng ???? ?????t ph??ng. (L??u ?? l?? c?? th??? c?? nhi???u d???ch v??? c?? s??? l???n s??? d???ng nhi???u nh?? nhau).

select dvdk.ma_dich_vu_di_kem , dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem from hop_dong_chi_tiet hdct join
dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem group by hdct.ma_dich_vu_di_kem having 
so_luong_dich_vu_di_kem>= all(select sum(hdct.so_luong) as so_luong_dich_vu_di_kem  from hop_dong_chi_tiet hdct join
dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem group by hdct.ma_dich_vu_di_kem);

-- 14.	Hi???n th??? th??ng tin t???t c??? c??c D???ch v??? ??i k??m ch??? m???i ???????c s??? d???ng m???t l???n duy nh???t. Th??ng tin hi???n th??? bao g???m ma_hop_dong, ten_loai_dich_vu, 
-- ten_dich_vu_di_kem, so_lan_su_dung (???????c t??nh d???a tr??n vi???c count c??c ma_dich_vu_di_kem).

select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_hop_dong) as so_lan_su_dung from
hop_dong hd join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu join hop_dong_chi_tiet hdct on hdct.ma_hop_dong= hd.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu 
group by dvdk.ma_dich_vu_di_kem having so_lan_su_dung=1;

-- 15.	Hi???n thi th??ng tin c???a t???t c??? nh??n vi??n bao g???m ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- m???i ch??? l???p ???????c t???i ??a 3 h???p ?????ng t??? n??m 2020 ?????n 2021.

select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi, count(hd.ma_hop_dong) 
as so_hop_dong_da_lap from nhan_vien nv join trinh_do td on nv.ma_trinh_do=td.ma_trinh_do join bo_phan bp 
on bp.ma_bo_phan=nv.ma_bo_phan join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien where year(hd.ngay_lam_hop_dong) between 2020 and 2021
group by hd.ma_nhan_vien having so_hop_dong_da_lap <=3 ;

-- 16.	X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2019 ?????n n??m 2021 .	
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien nv  where nv.ma_nhan_vien not in (select hd.ma_nhan_vien from hop_dong hd 
where year(hd.ngay_lam_hop_dong) between 2019 and 2021);

-- 17.	C???p nh???t th??ng tin nh???ng kh??ch h??ng c?? ten_loai_khach t??? Platinum l??n Diamond, ch??? c???p nh???t nh???ng kh??ch h??ng ???? t???ng ?????t ph??ng 
-- v???i T???ng Ti???n thanh to??n trong n??m 2021 l?? l???n h??n 10.000.000 VN??.

SET SQL_SAFE_UPDATES = 0;
update  khach_hang kh set kh.ma_loai_khach=1 where kh.ma_khach_hang in (select hd.ma_khach_hang from hop_dong hd  join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem where dv.chi_phi_thue+hdct.so_luong*dvdk.gia >10000000 group by hd.ma_khach_hang );

-- 18.	X??a nh???ng kh??ch h??ng c?? h???p ?????ng tr?????c n??m 2021 (ch?? ?? r??ng bu???c gi???a c??c b???ng).
SET SQL_SAFE_UPDATES = 0;
delete from hop_dong_chi_tiet hdct where hdct.ma_hop_dong in(select hd.ma_hop_dong from hop_dong hd where year(hd.ngay_lam_hop_dong)<2021);
delete from hop_dong hd where year(hd.ngay_lam_hop_dong)<2021;
delete from khach_hang kh where kh.ma_khach_hang not in (select hd.ma_khach_hang from hop_dong hd group by hd.ma_hop_dong);

-- 19.	C???p nh???t gi?? cho c??c d???ch v??? ??i k??m ???????c s??? d???ng tr??n 10 l???n trong n??m 2020 l??n g???p ????i.
SET SQL_SAFE_UPDATES = 0;
update dich_vu_di_kem dvdk set dvdk.gia=(dvdk.gia*2) where dvdk.ma_dich_vu_di_kem in
(select ma_dich_vu_di_kem from hop_dong_chi_tiet  group by ma_dich_vu_di_kem having sum(so_luong)>10);

-- 20.	Hi???n th??? th??ng tin c???a t???t c??? c??c nh??n vi??n v?? kh??ch h??ng c?? trong h??? th???ng, th??ng tin hi???n th??? bao g???m id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

select ma_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi from nhan_vien 
union all
select ma_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi from khach_hang ;

-- 21.	T???o khung nh??n c?? t??n l?? v_nhan_vien ????? l???y ???????c th??ng tin c???a t???t c??? c??c nh??n vi??n c?? ?????a ch??? l?? ???H???i Ch??u??? v?? ???? t???ng l???p h???p ?????ng cho m???t ho???c nhi???u kh??ch h??ng b???t k?? v???i ng??y l???p h???p ?????ng l?? ???12/12/2019???.

create view v_nhan_vien as
select * from nhan_vien nv where nv.dia_chi like '%H???i Ch??u%' and nv.ma_nhan_vien in 
(select hd.ma_nhan_vien from hop_dong hd where hd.ngay_lam_hop_dong='2019-12-12');

-- 22.	Th??ng qua khung nh??n v_nhan_vien th???c hi???n c???p nh???t ?????a ch??? th??nh ???Li??n Chi???u??? ?????i v???i t???t c??? c??c nh??n vi??n ???????c nh??n th???y b???i khung nh??n n??y.
SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien set dia_chi='Li??n Chi???u';

-- 23.	T???o Stored Procedure sp_xoa_khach_hang d??ng ????? x??a th??ng tin c???a m???t kh??ch h??ng n??o ???? v???i ma_khach_hang ???????c truy???n v??o nh?? l?? 1 tham s??? c???a sp_xoa_khach_hang.

DELIMITER //
create procedure sp_xoa_khach_hang (in id int)
begin
delete from khach_hang kh where kh.ma_khach_hang=id;
end //
DELIMITER ;

-- 24.	T???o Stored Procedure sp_them_moi_hop_dong d??ng ????? th??m m???i v??o b???ng hop_dong v???i y??u c???u sp_them_moi_hop_dong ph???i th???c hi???n ki???m tra t??nh h???p l??? c???a d??? li???u b??? sung,
-- v???i nguy??n t???c kh??ng ???????c tr??ng kh??a ch??nh v?? ?????m b???o to??n v???n tham chi???u ?????n c??c b???ng li??n quan.

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

-- 25.	T???o Trigger c?? t??n tr_xoa_hop_dong khi x??a b???n ghi trong b???ng hop_dong th?? hi???n th??? t???ng s??? l?????ng b???n ghi c??n l???i c?? trong b???ng hop_dong ra giao di???n console c???a database.
-- L??u ??: ?????i v???i MySQL th?? s??? d???ng SIGNAL ho???c ghi log thay cho vi???c ghi ??? console.

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

 -- 26.	T???o Trigger c?? t??n tr_cap_nhat_hop_dong khi c???p nh???t ng??y k???t th??c h???p ?????ng, c???n ki???m tra xem th???i gian c???p nh???t c?? ph?? h???p hay kh??ng,
 -- v???i quy t???c sau: Ng??y k???t th??c h???p ?????ng ph???i l???n h??n ng??y l??m h???p ?????ng ??t nh???t l?? 2 ng??y. N???u d??? li???u h???p l??? th?? cho ph??p c???p nh???t, 
 -- n???u d??? li???u kh??ng h???p l??? th?? in ra th??ng b??o ???Ng??y k???t th??c h???p ?????ng ph???i l???n h??n ng??y l??m h???p ?????ng ??t nh???t l?? 2 ng??y??? tr??n console c???a database.

DELIMITER //
create trigger tr_cap_nhat_hop_dong before update on hop_dong
for each row
begin
if year(ngay_lam_hop_dong) = year(ngay_ket_thuc) then
 if month(ngay_lam_hop_dong)> month(ngay_ket_thuc) 
  then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ng??y k???t th??c h???p ?????ng ph???i l???n h??n ng??y l??m h???p ?????ng ??t nh???t l?? 2 ng??y', MYSQL_ERRNO = 1005;
      end if;
	elseif month(ngay_lam_hop_dong)= month(ngay_ket_thuc) then
          if day(ngay_lam_hop_dong) > day(ngay_ket_thuc) or day(ngay_ket_thuc)-day(ngay_lam_hop_dong)<2
          then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ng??y k???t th??c h???p ?????ng ph???i l???n h??n ng??y l??m h???p ?????ng ??t nh???t l?? 2 ng??y', MYSQL_ERRNO = 1005;
      end if;
elseif year(ngay_lam_hop_dong) > year(ngay_ket_thuc)
then signal  SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Ng??y k???t th??c h???p ?????ng ph???i l???n h??n ng??y l??m h???p ?????ng ??t nh???t l?? 2 ng??y', MYSQL_ERRNO = 1005;
      end if;

end //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
update hop_dong  set ngay_lam_hop_dong='2022-03-15' where ma_hop_dong=3;