package model.repository;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceRepository {
    public boolean insertService(Service service) throws SQLException;
    public List<Service> selectAllServices();

}
