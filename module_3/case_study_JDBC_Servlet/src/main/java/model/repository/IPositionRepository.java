package model.repository;

import model.bean.Position;

import java.util.List;

public interface IPositionRepository {
    public List<Position> findAll();
}
