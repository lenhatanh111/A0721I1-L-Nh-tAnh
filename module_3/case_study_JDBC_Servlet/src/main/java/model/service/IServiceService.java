package model.service;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    public boolean insertService(Service service) throws SQLException;
    public List<Service> selectAllServices();
}
