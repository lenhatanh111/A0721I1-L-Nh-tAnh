package model.service;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    public boolean insertService(Service service) throws SQLException;
    public List<Service> selectAllServices();
    public List<Service> findServicesByName(String name);
    public Service selectServiceByName(String name);
    public boolean deleteService(int id,int service_id) throws SQLException;
}
