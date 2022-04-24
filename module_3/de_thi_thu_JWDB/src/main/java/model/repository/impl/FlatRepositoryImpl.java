package model.repository.impl;

import model.bean.Flat;
import model.repository.BaseRepository;
import model.repository.IFlatRepository;
import model.repository.IFlatTypeRepository;
import model.repository.IStatusRepository;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlatRepositoryImpl implements IFlatRepository {
    private static final String SELECT_ALL_FLAT ="select f.flat_id,s.status_name,f.area,fl.floor_number,ft.flat_type_name,f.cost,f.start_date,f.end_date,f.`description` from flat f inner join `status` s on \n" +
            "\tf.status_id=s.status_id inner join `floor` fl on f.floor_id=fl.floor_id inner join flat_type ft on f.flat_type_id=ft.flat_type_id order by f.area;";
    private static final String SEARCH ="select * from flat where flat_type_id like ? and start_date like ? and end_date like ? and floor_id like ?;";
    private static final String DELETE_FLAT_BY_ID ="delete from flat where flat_id=?;";
    private static final String ADD_NEW_FLAT ="insert into flat value(?,?,?,?,?,?,?,?,?);";


    @Override
    public List<Flat> findAll() {
        List<Flat> flats= new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FLAT);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("flat_id");
                String status_name=resultSet.getString("status_name");
                int area=resultSet.getInt("area");
                int floor=resultSet.getInt("floor_number");
                String flat_type_name=resultSet.getString("flat_type_name");
                double cost = resultSet.getDouble("cost");
                String start_date=resultSet.getString("start_date");
                String end_date=resultSet.getString("end_date");
                String description=resultSet.getString("description");
                flats.add(new Flat(id,status_name,area,floor,flat_type_name,cost,start_date,end_date,description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flats;
    }

    @Override
    public List<Flat> search(String flat_type_id, String start_date, String end_date, String floor) {
        IStatusRepository statusRepository= new StatusRepositoryImpl();
        IFlatTypeRepository flatTypeRepository=new FlatTypeRepositoryImpl();
        List<Flat> flats = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+flat_type_id+"%");
            preparedStatement.setString(2, "%"+start_date+"%");
            preparedStatement.setString(3, "%"+end_date+"%");
            preparedStatement.setString(4, "%"+floor+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("flat_id");
                int status_id = resultSet.getInt("status_id");
                int area = resultSet.getInt("area");
                int floor_num=resultSet.getInt("floor_id");
                int flat_type=resultSet.getInt("flat_type_id");
                double cost = resultSet.getDouble("cost");
                String start = resultSet.getString("start_date");
                String end = resultSet.getString("end_date");
                String description = resultSet.getString("description");
                flats.add(new Flat(id, statusRepository.findName(status_id), area, floor_num, flatTypeRepository.findName(flat_type), cost, start, end, description));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flats;
    }

        @Override
    public boolean delete(String id) {
        boolean check =false;
        Connection connection=BaseRepository.getConnect();
            try {
                PreparedStatement preparedStatement= connection.prepareStatement(DELETE_FLAT_BY_ID);
                preparedStatement.setString(1,id);
                check=preparedStatement.executeUpdate()>0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return check;
    }

    @Override
    public boolean add(Flat flat) {
        Connection connection=BaseRepository.getConnect();
        boolean check=false;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(ADD_NEW_FLAT);
            preparedStatement.setString(1,flat.getFlat_id());
            preparedStatement.setInt(2,flat.getStatus_id());
            preparedStatement.setInt(3,flat.getArea());
            preparedStatement.setInt(4,flat.getFloor());
            preparedStatement.setInt(5,flat.getFlat_type_id());
            preparedStatement.setDouble(6,flat.getCost());
            preparedStatement.setString(7,flat.getStart_date());
            preparedStatement.setString(8,flat.getEnd_date());
            preparedStatement.setString(9,flat.getDescription());
            check=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
