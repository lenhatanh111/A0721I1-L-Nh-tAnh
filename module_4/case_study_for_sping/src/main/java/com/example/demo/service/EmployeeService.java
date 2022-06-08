package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);

    void edit(Employee employee);

    Employee findById(int id);

    void delete(int id);

    Page<Employee> getAllEmployee(String name, String address, Pageable pageable);
    List<Employee> findAll();

}
