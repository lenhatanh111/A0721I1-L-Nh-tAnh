package model.service.impl;

import model.bean.Floor;
import model.repository.IFloorRepository;
import model.repository.impl.FloorRepositoryImpl;
import model.service.IFloorService;

import java.util.List;

public class FloorServiceImpl implements IFloorService {
    IFloorRepository floorRepository = new FloorRepositoryImpl();
    @Override
    public List<Floor> findAll() {
        return floorRepository.findAll();
    }
}
