package model.repository.impl;

import model.bean.BenhNhan;
import model.repository.BaseRepository;
import model.repository.IBenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements IBenhNhanRepository {
    private static final String SELECT_ALL_BENH_NHAN="select ba.ma_benh_an, bn.ma_benh_nhan, bn.ten_benh_nhan, bn.ngay_nhap_vien, bn.ngay_ra_vien, bn.ly_do from benh_nhan bn inner join benh_an ba on bn.ma_benh_nhan=ba.ma_benh_nhan;";
    private static final String UPDATE_BENH_NHAN="update benh_nhan bn set bn.ten_benh_nhan=?, bn.ngay_nhap_vien=?, bn.ngay_ra_vien=?, bn.ly_do=? where bn.ma_benh_nhan=(select ba.ma_benh_nhan from benh_an ba where ba.ma_benh_an=?);";
    private static final String DELETE_BENH_AN="delete from benh_an where ma_benh_an=?";
    private static final String FIND_BY_ID="select ba.ma_benh_an, bn.ma_benh_nhan, bn.ten_benh_nhan, bn.ngay_nhap_vien, bn.ngay_ra_vien, bn.ly_do from benh_nhan bn inner join benh_an ba on bn.ma_benh_nhan=ba.ma_benh_nhan where bn.ma_benh_nhan=?; ";
    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhans=new ArrayList<>();
        Connection connection= BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_BENH_NHAN);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String ma_benh_an=resultSet.getString("ma_benh_an");
                String ma_benh_nhan=resultSet.getString("ma_benh_nhan");
                String ten_benh_nhan=resultSet.getString("ten_benh_nhan");
                String ngay_nhap_vien=resultSet.getString("ngay_nhap_vien");
                String ngay_ra_vien=resultSet.getString("ngay_ra_vien");
                String ly_do=resultSet.getString("ly_do");
                benhNhans.add(new BenhNhan(ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do,ma_benh_an));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhNhans;
    }

    @Override
    public boolean edit(BenhNhan benhNhan) {
        boolean check=false;
        Connection connection=BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_BENH_NHAN);
            preparedStatement.setString(1,benhNhan.getTen_benh_nhan());
            preparedStatement.setString(2,benhNhan.getNgay_nhap_vien());
            preparedStatement.setString(3,benhNhan.getNgay_ra_vien());
            preparedStatement.setString(4,benhNhan.getLy_do());
            check=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }



    @Override
    public boolean delete(String id) {
        boolean check=false;
        Connection connection=BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_BENH_AN);
            preparedStatement.setString(1,id);
            check=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public BenhNhan findBenhNhanByID(String id) {
        Connection connection=BaseRepository.getConnect();
        BenhNhan benhNhan=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String ma_benh_an=resultSet.getString("ma_benh_an");
                String ma_benh_nhan=resultSet.getString("ma_benh_nhan");
                String ten_benh_nhan=resultSet.getString("ten_benh_nhan");
                String ngay_nhap_vien=resultSet.getString("ngay_nhap_vien");
                String ngay_ra_vien=resultSet.getString("ngay_ra_vien");
                String ly_do=resultSet.getString("ly_do");
                benhNhan=new BenhNhan(ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do,ma_benh_an);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhNhan;
    }
}
