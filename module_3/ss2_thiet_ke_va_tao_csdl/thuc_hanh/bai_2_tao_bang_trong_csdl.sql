create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh(
ma_hs varchar(20) primary key,
ten_hs varchar(50),
ngay_sinh datetime,
lop varchar(20),
gt varchar(20)
);
create table mon_hoc(
ma_mon_hoc varchar(20) primary key,
ten_mon_hoc varchar(50)
);
CREATE TABLE BangDiem(
    MaHS VARCHAR(20),
    MaMH VARCHAR(20),
    DiemThi INT,
    NgayKT DATETIME,
    PRIMARY KEY (MaHS, MaMH),
    FOREIGN KEY (MaHS) REFERENCES hoc_sinh(ma_hs),
    FOREIGN KEY (MaMH) REFERENCES mon_hoc(ma_mon_hoc)
);
CREATE TABLE GiaoVien(
    MaGV VARCHAR(20) PRIMARY KEY,
    TenGV VARCHAR(20),
    SDT VARCHAR(10)
);
alter table mon_hoc add MaGV varchar(20);
alter table mon_hoc add constraint FK_MaGV foreign key(MaGV) references GiaoVien(MaGV);