USE QuanLySinhVien;
select * from Student where Student.StudentName like "h%";
select *from Class where month(Class.StartDate)="12";
select * from `Subject` where `Subject`.Credit >=3 and `Subject`.Credit<=5;
update Student set ClassId="2" where (StudentName="Hung" and StudentId >0);
select Student.StudentName as "Name",Mark.Mark as"Mark" ,`Subject`.SubName from Mark left join Student on Student.StudentId=Mark.StudentId 
left join `Subject`on Mark.SubId=`Subject`.SubId order by Mark.Mark ;



