create database product;
use product;
create table phieu_xuat(
so_phieu_xuat int primary key,
ngay_xuat date
);
create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(15)
);
create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap date
);
create table nha_cung_cap(
ma_ncc int primary key,
ten_ncc varchar(15),
dia_chi varchar(50)
);
create table don_dat_hang(
so_dat_hang int primary key,
ngay_dat_hang date,
ma_ncc int,
foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);

create table sdt(
sdt int primary key ,
ma_ncc int,
foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);
create table don_dat_hang_vat_tu(
so_dat_hang int,
ma_vat_tu int,
primary key(so_dat_hang,ma_vat_tu),
foreign key(so_dat_hang) references don_dat_hang(so_dat_hang),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)

);
create table phieu_nhap_vat_tu(
don_gia_nhap double,
so_luong_nhap int,
ma_vat_tu int,
so_phieu_nhap int,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);
create table phieu_xuat_vat_tu(
don_gia_xuat double,
so_luong_xuat int,
ma_vat_tu int,
so_phieu_xuat int,
primary key(ma_vat_tu,so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat)
);
