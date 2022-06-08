package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
repository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return repository.findCustomerById(id);
    }

    @Override
    public void delete(int id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer != null) {
            repository.delete(customer);
        }
    }

    @Override
    public Page<Customer> getAllCustomer(String name, String address, Pageable pageable) {
        return repository.findAll(name,address,pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return repository.findAll();
    }
}
