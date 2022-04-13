package model.repository.impl;

import model.bean.Education_degree;
import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    private static final String SELECT_ALL_EDUCATION_DEGREE="select * from education_degree;";
    @Override
    public List<Education_degree> findAll() {
        List<Education_degree> education_degrees= new ArrayList<>();
        Connection connection= BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                education_degrees.add(new Education_degree(id,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return education_degrees;
    }
}
