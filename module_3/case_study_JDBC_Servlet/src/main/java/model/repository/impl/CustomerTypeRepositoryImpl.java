package model.repository.impl;

import model.bean.Customer_type;
import model.repository.BaseRepository;
import model.repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMER_TYPE="select * from customer_type;";
    @Override
    public List<Customer_type> findAll() {
        List<Customer_type> customer_types= new ArrayList<>();
        Connection connection=BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customer_types.add(new Customer_type(id,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer_types;
    }
}
