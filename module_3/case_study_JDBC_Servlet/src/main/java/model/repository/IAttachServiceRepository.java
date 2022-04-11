package model.repository;

import model.bean.Attach_service;
import model.bean.Contract_detail;

import java.util.List;

public interface IAttachServiceRepository {
    public Attach_service selectAttachService(int id);
}
