package model.repository.impl;

import model.bean.Division;
import model.bean.Education_degree;
import model.repository.BaseRepository;
import model.repository.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISION="select * from division;";
    @Override
    public List<Division> findAll() {
        List<Division> divisions= new ArrayList<>();
        Connection connection= BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                divisions.add(new Division(id,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisions;
    }
}
