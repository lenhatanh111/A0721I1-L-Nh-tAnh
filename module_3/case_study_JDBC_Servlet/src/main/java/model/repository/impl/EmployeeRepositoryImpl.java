package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String INSERT_IN_TO_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary,employee_phone ,employee_email ,employee_address, position_id,education_degree_id,division_id,username) value\n" +
            "(?,?,?,?,?,?,?,?,?,?,?); ";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id=?;";
    private static final String SELECT_ALL_EMPLOYEES = "select e.employee_id,e.employee_name, e.employee_birthday, e.employee_id_card, e.employee_salary,e.employee_phone ,e.employee_email ,e.employee_address, p.positon_name,ed.education_degree_name,d.division_name,username from employee e inner join position p on e.position_id=p.position_id inner join education_degree ed on e.education_degree_id =ed.education_degree_id inner join division d on e.division_id=d.division_id ;";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name=?, employee_birthday=?, employee_id_card=?, employee_salary=?,employee_phone =?,employee_email =?,employee_address=?, position_id=?,education_degree_id=?,division_id=?,username=? where employee_id=?;";
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id =?;";
    private static final String FIND_EMPLOYEES_BY_NAME = "select * from employee where employee_name like ?;";
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_IN_TO_EMPLOYEE);
        preparedStatement.setString(1, employee.getEmployee_name());
        preparedStatement.setString(2, employee.getEmployee_birthday());
        preparedStatement.setString(3,employee.getEmployee_id_card());
        preparedStatement.setDouble(4,employee.getEmployee_salary());
        preparedStatement.setString(5,employee.getEmployee_phone());
        preparedStatement.setString(6,employee.getEmployee_email());
        preparedStatement.setString(7,employee.getEmployee_address());
        preparedStatement.setInt(8,employee.getPosition_id());
        preparedStatement.setInt(9,employee.getEducation_degree_id());
        preparedStatement.setInt(10,employee.getDivision_id());
        preparedStatement.setString(11,employee.getUsername());

        check =preparedStatement.executeUpdate()>0;

        return check;

    }

    @Override
    public Employee selectEmployee(int id) {
        Connection connection = BaseRepository.getConnect();
        Employee employee =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String id_card = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username= resultSet.getString("username");
               employee = new Employee(id,name,birthday,id_card,salary,phone,email,address,position_id,education_degree_id,division_id,username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String id_card = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String position_name = resultSet.getString("positon_name");
                String education_degree_name = resultSet.getString("education_degree_name");
                String division_name = resultSet.getString("division_name");
                String username= resultSet.getString("username");
                employees.add(new Employee(id,name,birthday,id_card,salary,phone,email,address,position_name,education_degree_name,division_name,username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> findEmployeesByName(String name) {
        List<Employee> employees = new ArrayList<>();

        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_EMPLOYEES_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String e_name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String id_card = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username= resultSet.getString("username");
                employees.add(new Employee(id,e_name,birthday,id_card,salary,phone,email,address,position_id,education_degree_id,division_id,username));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
        preparedStatement.setInt(1,id);
        check =preparedStatement.executeUpdate()>0;

        return check;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_EMPLOYEE);
        preparedStatement.setString(1, employee.getEmployee_name());
        preparedStatement.setString(2, employee.getEmployee_birthday());
        preparedStatement.setString(3,employee.getEmployee_id_card());
        preparedStatement.setDouble(4,employee.getEmployee_salary());
        preparedStatement.setString(5,employee.getEmployee_phone());
        preparedStatement.setString(6,employee.getEmployee_email());
        preparedStatement.setString(7,employee.getEmployee_address());
        preparedStatement.setInt(8,employee.getPosition_id());
        preparedStatement.setInt(9,employee.getEducation_degree_id());
        preparedStatement.setInt(10,employee.getDivision_id());
        preparedStatement.setString(11,employee.getUsername());
        preparedStatement.setInt(12,employee.getEmployee_id());

        check =preparedStatement.executeUpdate()>0;

        return check;
    }
}
