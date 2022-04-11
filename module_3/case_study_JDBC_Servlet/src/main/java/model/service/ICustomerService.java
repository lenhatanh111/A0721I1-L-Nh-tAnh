package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public List<String> insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();
    public List<Customer> findCustomersByName(String name);

    public boolean deleteCustomer(int id) throws SQLException;

    public  List<String> updateCustomer(Customer customer) throws SQLException;
    public List<Customer> selectAllCustomersAreUsingService();
}
