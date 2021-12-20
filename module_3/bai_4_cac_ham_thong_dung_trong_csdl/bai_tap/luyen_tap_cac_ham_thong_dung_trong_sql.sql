use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select max(Credit), SubName from `Subject`;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất
select max(mark), SubName from mark inner join `Subject` on mark.SubId=`Subject`.SubId;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select avg(mark) as dtb,StudentName from  mark inner join `Student` on mark.StudentId=`Student`.StudentId group by Student.StudentId order by dtb desc;