package model.service.impl;

import model.bean.Status;
import model.repository.IStatusRepository;
import model.repository.impl.StatusRepositoryImpl;
import model.service.IStatusService;

import java.util.List;

public class StatusServiceImpl implements IStatusService {
    IStatusRepository statusRepository = new StatusRepositoryImpl();
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
