package model.repository.impl;

import model.bean.Status;
import model.repository.BaseRepository;
import model.repository.IStatusRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepositoryImpl implements IStatusRepository {
    private static final String SELECT_ALL_STATUS="select * from status;";
    private static final String FIND_STATUS_NAME_BY_ID="select status_name from `status` where status_id=?;";
    @Override
    public List<Status> findAll() {
        List<Status> statuses=new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_STATUS);
            ResultSet resultSet =preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("status_id");
                String name=resultSet.getString("status_name");
                statuses.add(new Status(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public String findName(int id) {
        Connection connection = BaseRepository.getConnect();
        String name= null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_STATUS_NAME_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                name=resultSet.getString("status_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}
