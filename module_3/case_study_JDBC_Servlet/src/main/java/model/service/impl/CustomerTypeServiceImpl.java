package model.service.impl;

import model.bean.Customer_type;
import model.repository.ICustomerTypeRepository;
import model.repository.impl.CustomerTypeRepositoryImpl;
import model.service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository =new CustomerTypeRepositoryImpl();
    @Override
    public List<Customer_type> findAll() {
        return customerTypeRepository.findAll();
    }
}
