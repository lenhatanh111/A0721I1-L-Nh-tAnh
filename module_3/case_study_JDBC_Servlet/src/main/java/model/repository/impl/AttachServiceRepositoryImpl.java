package model.repository.impl;

import model.bean.Attach_service;
import model.bean.Contract_detail;
import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.IAttachServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepositoryImpl implements IAttachServiceRepository {
    private static final String SELECT_ATTACH_SERVICE_BY_ID = "select * from attach_service where attach_service_id=?;";
    @Override
    public Attach_service selectAttachService(int id) {
        Connection connection = BaseRepository.getConnect();
        Attach_service attach_service =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ATTACH_SERVICE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("attach_service_name");
                Double cost =resultSet.getDouble("attach_service_cost");
                Integer unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                attach_service = new Attach_service(id, name,cost,unit,status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attach_service;
    }
}

