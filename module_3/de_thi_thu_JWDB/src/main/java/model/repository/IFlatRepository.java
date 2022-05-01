package model.repository;

import model.bean.Flat;

import java.util.List;

public interface IFlatRepository {
    public List<Flat> findAll();
    public List<Flat> search(String flat_type_id,String start_date,String end_date,String floor);
    public boolean delete(String id);
    public boolean add(Flat flat);
}