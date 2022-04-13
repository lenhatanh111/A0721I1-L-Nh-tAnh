package model.repository.impl;

import model.bean.Customer_type;
import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    private static final String SELECT_ALL_POSITION ="select * from position;";
    @Override
    public List<Position> findAll() {
        List<Position> positions= new ArrayList<>();
        Connection connection= BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("positon_name");
                positions.add(new Position(id,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }
}
