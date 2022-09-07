package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value="select * from student"
            ,nativeQuery=true
            ,countQuery="select count(*) from (select * from student) abc")
    Page<Student>fidAll(Pageable pageable);
    Student findById(int id);
}
