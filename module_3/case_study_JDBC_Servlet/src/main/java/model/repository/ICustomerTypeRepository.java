package model.repository;

import model.bean.Customer_type;

import java.util.List;

public interface ICustomerTypeRepository {
    public List<Customer_type> findAll();
}
