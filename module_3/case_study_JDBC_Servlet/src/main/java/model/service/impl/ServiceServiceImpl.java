package model.service.impl;

import model.bean.Service;
import model.repository.IServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public boolean insertService(Service service) throws SQLException {
        return serviceRepository.insertService(service);
    }

    @Override
    public List<Service> selectAllServices() {
        return serviceRepository.selectAllServices();
    }
}
