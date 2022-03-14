USE QuanLySinhVien;
-- Hiển thị số lượng sinh viên ở từng nơi--
select s.Address, count(s.StudentId) as so_luong from student as s group by s.Address;
-- Tính điểm trung bình các môn học của mỗi học viên--
select s.StudentName,avg(m.mark) from student as s join mark as m  on s.StudentId=m.StudentId group by m.StudentId;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15--
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.--
SELECT S.StudentId,S.StudentName, AVG(M.Mark) as dtb 
FROM Student S join Mark M on S.StudentId = M.StudentId 
GROUP BY S.StudentId, S.StudentName having dtb >= all(select avg(M.Mark) from Mark M group by M.StudentId); 