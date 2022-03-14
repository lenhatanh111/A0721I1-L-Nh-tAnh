create database quan_ly_don_hang;
use quan_ly_don_hang;
create table sdt(
id int primary key auto_increment,
sdt varchar(20)
);
create table ncc(
ma_ncc varchar(50) not null primary key,
ten_ncc varchar(50),
dia_chi varchar(250),
id_sdt int,
foreign key(id_sdt) references sdt(id) 
);
create table don_dh(
so_dh int primary key,
ngay_dh date,
ma_ncc varchar(50),
foreign key(ma_ncc) references ncc(ma_ncc)
);
create table vat_tu(
ma_vt varchar(50) primary key,
ten_vt varchar(50)
);
create table phieu_nhap(
so_pn varchar(50) primary key,
ngay_nhap date
);
create table phieu_xuat(
so_px varchar(50) primary key,
ngay_xuat date
);
create table don_dh_vt(
ma_vt varchar(50),
so_dh int,
primary key(ma_vt,so_dh),
foreign key(ma_vt) references vat_tu(ma_vt),
foreign key(so_dh) references don_dh(so_dh)
);
create table phieu_nhap_vt(
dg_nhap int,
sl_nhap int,
ma_vt varchar(50),
so_pn varchar(50),
primary key(ma_vt,so_pn) ,
foreign key(ma_vt) references vat_tu(ma_vt),
foreign key(so_pn) references phieu_nhap(so_pn)
);
create table phieu_xuat_vt(
dg_xuat int,
sl_xuat int,
so_px varchar(50),
ma_vt varchar(50),
primary key(so_px,ma_vt),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vt) references vat_tu(ma_vt)
);