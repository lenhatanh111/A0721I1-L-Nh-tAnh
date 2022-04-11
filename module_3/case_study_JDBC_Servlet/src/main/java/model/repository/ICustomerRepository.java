package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public boolean insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();
    public List<Customer> findCustomersByName(String name);
    public List<Customer> selectAllCustomersAreUsingService();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
}
