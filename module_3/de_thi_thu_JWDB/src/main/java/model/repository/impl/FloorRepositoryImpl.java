package model.repository.impl;

import model.bean.Floor;
import model.repository.BaseRepository;
import model.repository.IFloorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FloorRepositoryImpl implements IFloorRepository {
    private static final String SELECT_ALL_FLOOR ="select * from floor;";
    @Override
    public List<Floor> findAll() {
        List<Floor> floors = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_FLOOR);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("floor_id");
                int number=resultSet.getInt("floor_number");
                floors.add(new Floor(id,number));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return floors;
    }
}
