package model.repository.impl;

import model.bean.FlatType;
import model.bean.Status;
import model.repository.BaseRepository;
import model.repository.IFlatTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlatTypeRepositoryImpl implements IFlatTypeRepository {
    private static final String SELECT_ALL_FLAT_TYPE = "select * from flat_type;";
    private static final String FIND_FLAT_TYPE_NAME_BY_ID = "select flat_type_name from flat_type where flat_type_id=?;";

    @Override
    public List<FlatType> findAll() {
        List<FlatType> flatTypes = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FLAT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("flat_type_id");
                String name = resultSet.getString("flat_type_name");
                flatTypes.add(new FlatType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flatTypes;
    }

    @Override
    public String findName(int id) {
        Connection connection = BaseRepository.getConnect();
        String name= null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_FLAT_TYPE_NAME_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("flat_type_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}
