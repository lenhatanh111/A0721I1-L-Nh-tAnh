package model.repository.impl;

import model.bean.Customer;
import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    private static final String INSERT_IN_TO_SERVICE = "insert into service (service_name, service_area, service_cost, service_max_people,rent_type_id ,service_type_id ,standard_room, description_other_convenience,pool_area,number_of_floors) value\n" +
            "(?,?,?,?,?,?,?,?,?,?); ";
    private static final String SELECT_ALL_SERVICES = "select * from service ;";
    private static final String SELECT_SERVICE_BY_NAME = "select * from service where service_name=?;";
    private static final String FIND_SERVICE_BY_NAME = "select * from service where service_name=? ;";
    private static final String DELETE_SERVICE_OF_CUSTOMER = "update contract  set service_id = null where customer_id=? and service_id =?";

    @Override
    public boolean insertService(Service service) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(INSERT_IN_TO_SERVICE);
        preparedStatement.setString(1, service.getService_name());
        preparedStatement.setInt(2, service.getService_area());
        preparedStatement.setDouble(3,service.getService_cost());
        preparedStatement.setInt(4,service.getService_max_people());
        preparedStatement.setInt(5,service.getRent_type_id());
        preparedStatement.setInt(6,service.getService_type_id());
        preparedStatement.setString(7,service.getStandard_room());
        preparedStatement.setString(8,service.getDescription_other_convenience());
        preparedStatement.setDouble(9,service.getPool_area());
        preparedStatement.setInt(10,service.getNumber_of_floors());
        check =preparedStatement.executeUpdate()>0;

        return check;
    }

    @Override
    public List<Service> selectAllServices() {
        List<Service> services = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("service_id");
                String name= resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double cost= resultSet.getDouble("service_cost");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int max_people =resultSet.getInt("service_max_people");
               services.add(new Service(id,name,service_area,cost,max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }



    @Override
    public List<Service> findServicesByName(String name) {
        List<Service> services = new ArrayList<>();

        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_SERVICE_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("service_id");
                String service_name= resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double cost= resultSet.getDouble("service_cost");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int max_people =resultSet.getInt("service_max_people");
                services.add(new Service(id,service_name,service_area,cost,max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public Service selectServiceByName(String name) {
      Service service=null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int service_id=resultSet.getInt("service_id");
                int service_area = resultSet.getInt("service_area");
                double cost= resultSet.getDouble("service_cost");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int max_people =resultSet.getInt("service_max_people");
              service= new Service(service_id,name,service_area,cost,max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public boolean deleteService(int id,int service_id) throws SQLException {
        boolean check =false;
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement =connection.prepareStatement(DELETE_SERVICE_OF_CUSTOMER);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,service_id);
        check =preparedStatement.executeUpdate()>0;

        return check;
    }



}
