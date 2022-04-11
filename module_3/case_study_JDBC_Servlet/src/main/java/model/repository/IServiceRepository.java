package model.repository;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceRepository {
    public boolean insertService(Service service) throws SQLException;
    public List<Service> selectAllServices();
    public List<Service> findServicesByName(String name);
public Service selectServiceByName(String name);
    public boolean deleteService(int id,int service_id) throws SQLException;

}
