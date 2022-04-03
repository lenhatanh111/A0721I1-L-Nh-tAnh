package model.repository.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.ICustomerRepository;
import org.graalvm.compiler.lir.StandardOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final String INSERT_IN_TO_CUSTOMER = "insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card,customer_phone ,customer_email ,customer_address, customer_type_id) value\n" +
            "(?,?,?,?,?,?,?,?); ";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?;";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer ;";
    private static final String UPDATE_CUSTOMER = "update customer set customer_name =?, customer_birthday =?, customer_gender =?, customer_id_card =?, customer_phone =?, customer_email =?, customer_address =?, customer_type_id =? where customer_id=?;";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id =?;";
    private static final String FIND_CUSTOMERS_BY_NAME = "select * from customer where customer_name like ?;";


    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_IN_TO_CUSTOMER);
        preparedStatement.setString(1, customer.getCustomer_name());
        preparedStatement.setString(2, customer.getCustomer_birthday());
        preparedStatement.setInt(3,customer.getCustomer_gender());
        preparedStatement.setString(4,customer.getCustomer_id_card());
        preparedStatement.setString(5,customer.getCustomer_phone());
        preparedStatement.setString(6,customer.getCustomer_email());
        preparedStatement.setString(7,customer.getCustomer_address());
        preparedStatement.setInt(8,customer.getCustomer_type_id());

        check =preparedStatement.executeUpdate()>0;

        return check;

    }

    @Override
    public Customer selectCustomer(int id) {
        Connection connection = BaseRepository.getConnect();
        Customer customer =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int type_id = resultSet.getInt("customer_type_id");
                customer = new Customer(id, name, birthday, gender, id_card, phone, email, address, type_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("customer_id");
               String name = resultSet.getString("customer_name");
               String birthday = resultSet.getString("customer_birthday");
               Integer gender = resultSet.getInt("customer_gender");
               String id_card =resultSet.getString("customer_id_card");
               String phone =resultSet.getString("customer_phone");
               String email =resultSet.getString("customer_email");
               String address =resultSet.getString("customer_address");
               int type_id = resultSet.getInt("customer_type_id");
               customers.add(new Customer(id,name,birthday,gender,id_card,phone,email,address,type_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();

        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_CUSTOMERS_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id= resultSet.getInt("customer_id");
                String customer_name =resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int type_id = resultSet.getInt("customer_type_id");
                customers.add(new Customer(id, customer_name, birthday, gender, id_card, phone, email, address, type_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
            PreparedStatement preparedStatement =connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
           check =preparedStatement.executeUpdate()>0;

        return check;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1, customer.getCustomer_name());
        preparedStatement.setString(2, customer.getCustomer_birthday());
        preparedStatement.setInt(3,customer.getCustomer_gender());
        preparedStatement.setString(4,customer.getCustomer_id_card());
        preparedStatement.setString(5,customer.getCustomer_phone());
        preparedStatement.setString(6,customer.getCustomer_email());
        preparedStatement.setString(7,customer.getCustomer_address());
        preparedStatement.setInt(8,customer.getCustomer_type_id());
        preparedStatement.setInt(9,customer.getCustomer_id());

        check =preparedStatement.executeUpdate()>0;

        return check;
    }
}
