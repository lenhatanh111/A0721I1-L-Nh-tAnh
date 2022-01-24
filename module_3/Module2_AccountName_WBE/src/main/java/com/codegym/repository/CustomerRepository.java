package com.codegym.repository;

import com.codegym.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository=new BaseRepository();

    @Override
    public ArrayList<Customer> display() {
        ArrayList<Customer> customers=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select*from customer inner join customer_type on customer.customer_type_id = customer_type.customer_type_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                customers.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void create( String customer_name, String customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String customer_type_id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("insert into khach_hang values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,customer_name);
            preparedStatement.setString(2, customer_birthday);
            preparedStatement.setInt(3, Integer.parseInt(customer_gender));
            preparedStatement.setString(4,customer_id_card);
            preparedStatement.setString(5,customer_phone);
            preparedStatement.setString(6,customer_email);
            preparedStatement.setString(7,customer_address);
            preparedStatement.setInt(8,Integer.parseInt(customer_type_id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String customer_id) {
        Integer temp = Integer.parseInt(customer_id);
        try {
            PreparedStatement preparedStatement1 = this.baseRepository.getConnection()
                    .prepareStatement("delete from contract where customer_id = ?;");
            preparedStatement1.setInt(1, temp);
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("delete from customer where customer_id = ?;");
            preparedStatement.setInt(1,temp);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update( String customer_name, String customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String customer_type_id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("update customer set customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ? , customer_email=?, customer_address=?, customer_type_id=?  where customer_id = ?");
            preparedStatement.setString(1,customer_name);
            preparedStatement.setString(2,customer_birthday);
            preparedStatement.setInt(3, Integer.parseInt(customer_gender));
            preparedStatement.setString(4,customer_id_card);
            preparedStatement.setString(5,customer_phone);
            preparedStatement.setString(6,customer_email);
            preparedStatement.setString(7,customer_address);
            preparedStatement.setInt(8,Integer.parseInt(customer_type_id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> search(String customer_name) {
        try {
            List<Customer> list = new ArrayList<>();
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from customer inner join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name like ?;");
            preparedStatement.setString(1,"%" +customer_name +"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                list.add(customer);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
