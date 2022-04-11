package model.service.impl;

import common.Validate;
import model.bean.Customer;
import model.repository.ICustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
   private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<String> insertCustomer(Customer customer) throws SQLException {
       List<String> messList =new ArrayList<>();
       boolean check=true;
       if (Validate.checkIDCard(customer.getCustomer_id_card())){
           messList.add("");
       }else {
           check =false;
           messList.add("CMND khong dung dinh dang");
       }
        if (Validate.checkPhone(customer.getCustomer_phone())){
            messList.add("");
        }else {
            check =false;
            messList.add("SDT khong dung dinh dang");
        }
        if (Validate.checkEmail(customer.getCustomer_email())){
            messList.add("");
        }else {
            check =false;
            messList.add("Email khong dung dinh dang");
        }
        if (check){
            customerRepository.insertCustomer(customer);
        }
        return messList;
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
    public  List<String> updateCustomer(Customer customer) throws SQLException {
        List<String> messList =new ArrayList<>();
        boolean check=true;
        if (Validate.checkIDCard(customer.getCustomer_id_card())){
            messList.add("");
        }else {
            check =false;
            messList.add("CMND khong dung dinh dang");
        }
        if (Validate.checkPhone(customer.getCustomer_phone())){
            messList.add("");
        }else {
            check =false;
            messList.add("SDT khong dung dinh dang");
        }
        if (Validate.checkEmail(customer.getCustomer_email())){
            messList.add("");
        }else {
            check =false;
            messList.add("Email khong dung dinh dang");
        }
        if (check){
            customerRepository.updateCustomer(customer);
        }
        return messList;
    }

    @Override
    public List<Customer> selectAllCustomersAreUsingService() {
        return customerRepository.selectAllCustomersAreUsingService();
    }
}
