package model.service.impl;

import common.Validate;
import model.bean.Employee;
import model.repository.IEmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<String> insertEmployee(Employee employee) throws SQLException {
        List<String> messList =new ArrayList<>();
        boolean check=true;
        if (Validate.checkIDCard(employee.getEmployee_id_card())){
            messList.add("");
        }else {
            check =false;
            messList.add("CMND khong dung dinh dang");
        }
        if (Validate.checkPhone(employee.getEmployee_phone())){
            messList.add("");
        }else {
            check =false;
            messList.add("SDT khong dung dinh dang");
        }
        if (Validate.checkEmail(employee.getEmployee_email())){
            messList.add("");
        }else {
            check =false;
            messList.add("Email khong dung dinh dang");
        }
        if (check){
            employeeRepository.insertEmployee(employee);
        }
        return messList;
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findEmployeesByName(name);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<String> updateEmployee(Employee employee) throws SQLException {
        List<String> messList =new ArrayList<>();
        boolean check=true;
        if (Validate.checkIDCard(employee.getEmployee_id_card())){
            messList.add("");
        }else {
            check =false;
            messList.add("CMND khong dung dinh dang");
        }
        if (Validate.checkPhone(employee.getEmployee_phone())){
            messList.add("");
        }else {
            check =false;
            messList.add("SDT khong dung dinh dang");
        }
        if (Validate.checkEmail(employee.getEmployee_email())){
            messList.add("");
        }else {
            check =false;
            messList.add("Email khong dung dinh dang");
        }
        if (check){
            employeeRepository.updateEmployee(employee);
        }
        return messList;
    }
}
