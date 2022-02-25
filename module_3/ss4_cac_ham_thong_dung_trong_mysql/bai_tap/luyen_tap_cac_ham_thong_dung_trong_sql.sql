use QuanLySinhVien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.--
select *  from `subject` as s  order by s.Credit desc limit 1;
select *  from `subject` as s  where s.Credit = all(select max(s.Credit) from `subject` as s);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.--
select * from `subject` as s join mark as m on s.SubId=m.SubId where m.Mark = all(select max(m.Mark) from mark as m) ;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần--
select *, avg(m.mark) from student as s join mark as m on s.StudentId=m.StudentId group by s.StudentId order by m.Mark desc;