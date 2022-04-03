package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public boolean insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();
    public List<Employee> findEmployeesByName(String name);

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
}
