package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository= new CustomerRepository();


    @Override
    public List<Customer> display() {
        return iCustomerRepository.display();
    }

    @Override
    public void create(String customer_name, String customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String customer_type_id) {
iCustomerRepository.create(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id);
    }

    @Override
    public void delete(String customer_id) {
iCustomerRepository.delete(customer_id);
    }

    @Override
    public void update(String customer_name, String customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String customer_type_id) {
iCustomerRepository.update(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id);
    }

    @Override
    public List<Customer> search(String customer_name) {
        return iCustomerRepository.search(customer_name);
    }
}
