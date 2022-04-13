package model.repository;

import model.bean.Education_degree;

import java.util.List;

public interface IEducationDegreeRepository {
    public List<Education_degree> findAll();
}
