package model.repository;

import model.bean.Floor;

import java.util.List;

public interface IFloorRepository {
    public List<Floor> findAll();
}
