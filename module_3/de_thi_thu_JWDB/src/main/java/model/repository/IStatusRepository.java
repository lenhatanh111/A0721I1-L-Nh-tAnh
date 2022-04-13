package model.repository;

import model.bean.Status;

import java.util.List;

public interface IStatusRepository {
    public List<Status> findAll();
}
