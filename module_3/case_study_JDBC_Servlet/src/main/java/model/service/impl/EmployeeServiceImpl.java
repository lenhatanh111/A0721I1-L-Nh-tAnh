package model.service.impl;

import model.bean.Employee;
import model.repository.IEmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        return employeeRepository.insertEmployee(employee);
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
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }
}
