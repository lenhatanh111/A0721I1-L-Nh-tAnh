package com.codegym.service;

import com.codegym.model.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_db?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123123";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id from customer where customer_id=?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?,customer_type_id=?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    public CustomerService() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertCustomer(customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCustomer_name());
            preparedStatement.setString(2, customer.getCustomer_birthday());
            preparedStatement.setInt(3, customer.getCustomer_gender());
            preparedStatement.setString(4, customer.getCustomer_id_card());
            preparedStatement.setString(5, customer.getCustomer_phone());
            preparedStatement.setString(6, customer.getCustomer_email());
            preparedStatement.setString(7, customer.getCustomer_address());
            preparedStatement.setInt(8, customer.getCustomer_type_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }


    @Override
    public customer selectCustomer(int customer_id) {
        customer customer = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1,customer_id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {

                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                int customer_gender = rs.getInt("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email= rs.getString("customer_email");
                String customer_address= rs.getString("customer_address");
                int customer_type_id=rs.getInt("customer_type_id");
                customer = new customer(customer_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<customer> selectAllCustomer() {
        List<customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int customer_id = rs.getInt("id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                int customer_gender = rs.getInt("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email= rs.getString("customer_email");
                String customer_address= rs.getString("customer_address");
                int customer_type_id=rs.getInt("customer_type_id");
                customers.add(new customer(customer_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int customer_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, customer_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
           statement.setString(1, customer.getCustomer_name());
            statement.setString(2, customer.getCustomer_birthday());
            statement.setInt(3, customer.getCustomer_gender());
            statement.setString(4, customer.getCustomer_id_card());
            statement.setString(5, customer.getCustomer_phone());
            statement.setString(6, customer.getCustomer_email());
            statement.setString(7, customer.getCustomer_address());
            statement.setInt(8, customer.getCustomer_type_id());
            statement.setInt(9, customer.getCustomer_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
