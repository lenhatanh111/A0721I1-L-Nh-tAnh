package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT * FROM employee where employee_name like concat('%',:name,'%') and employee_address like concat('%',:address,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM employee where employee_name like concat('%',:name,'%') and employee_address like concat('%',:address,'%')) abc" )
    Page<Employee> findAll(@Param("name") String name, @Param("address") String address, Pageable pageable);
    Employee findById(int id);
}
