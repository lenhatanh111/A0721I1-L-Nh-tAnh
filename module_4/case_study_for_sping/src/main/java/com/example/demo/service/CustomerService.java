package com.example.demo.service;


import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    void edit(Customer customer);

    Customer findById(int id);

    void delete(int id);

    Page<Customer> getAllCustomer(String name,String address,Pageable pageable);

    List<Customer> findAllCustomer();
}
