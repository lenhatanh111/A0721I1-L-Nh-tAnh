package com.codegym.service;

import com.codegym.model.customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public void insertCustomer(customer customer) throws SQLException;

    public customer selectCustomer(int customer_id);

    public List<customer> selectAllCustomer();

    public boolean deleteCustomer(int customer_id) throws SQLException;

    public boolean updateCustomer(customer customer) throws SQLException;
}
