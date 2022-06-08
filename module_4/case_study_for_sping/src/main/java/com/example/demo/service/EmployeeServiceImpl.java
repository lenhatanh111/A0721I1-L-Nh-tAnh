package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Employee employee) {
        boolean check = false;
        for (User user : userRepository.findAll()) {
            if (user.getName().equals(employee.getEmployeeEmail())) {
                employee.setUser(user);
                check = true;
                break;
            }
        }
        if (!check) {
            User user = new User();
            user.setName(employee.getEmployeeEmail());
            user.setPassword("123123");
            userRepository.save(user);
            employee.setUser(user);
        }
        repository.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        Employee employee = repository.findById(id);
        if (employee != null) {
            repository.delete(employee);
        }
    }


    @Override
    public Page<Employee> getAllEmployee(String name, String address, Pageable pageable) {
        return repository.findAll(name, address, pageable);
    }
}
