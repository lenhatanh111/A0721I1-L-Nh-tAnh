package model.service.impl;

import model.bean.Customer;
import model.repository.ICustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
   private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        return customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return customerRepository.findCustomersByName(name);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> selectAllCustomersAreUsingService() {
        return customerRepository.selectAllCustomersAreUsingService();
    }
}
