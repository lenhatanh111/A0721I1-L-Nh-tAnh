package model.repository;

import model.bean.Division;

import java.util.List;

public interface IDivisionRepository {
    public List<Division> findAll();
}
