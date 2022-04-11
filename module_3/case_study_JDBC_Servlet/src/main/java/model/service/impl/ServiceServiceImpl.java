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



    @Override
    public List<Service> findServicesByName(String name) {
        return serviceRepository.findServicesByName(name);
    }

    @Override
    public Service selectServiceByName(String name) {
        return serviceRepository.selectServiceByName(name);
    }


    @Override
    public boolean deleteService(int id,int service_id) throws SQLException {
        return serviceRepository.deleteService(id,service_id);
    }

}
