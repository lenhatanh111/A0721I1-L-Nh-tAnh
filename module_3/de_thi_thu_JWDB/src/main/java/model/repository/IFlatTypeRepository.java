package model.repository;

import model.bean.FlatType;

import java.util.List;

public interface IFlatTypeRepository {
    public List<FlatType> findAll();
    public String findName(int id);
}
