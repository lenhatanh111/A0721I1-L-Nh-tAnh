package model.repository.impl;

import model.bean.BenhAn;
import model.repository.BaseRepository;
import model.repository.IBenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements IBenhAnRepository {
    private static final String SELECT_ALL_BENH_AN="select * from benh_an;";
    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAns=new ArrayList<>();
        Connection connection= BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_BENH_AN);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String ma_benh_an=resultSet.getString("ma_benh_an");
                String ma_benh_nhan=resultSet.getString("ma_benh_nhan");
                benhAns.add(new BenhAn(ma_benh_an,ma_benh_nhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhAns;
    }
}
