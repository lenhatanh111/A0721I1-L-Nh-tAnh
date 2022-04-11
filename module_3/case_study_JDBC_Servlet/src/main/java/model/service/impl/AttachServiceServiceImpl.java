package model.service.impl;

import model.bean.Attach_service;
import model.repository.IAttachServiceRepository;
import model.repository.impl.AttachServiceRepositoryImpl;
import model.service.IAttachServiceService;

public class AttachServiceServiceImpl implements IAttachServiceService {
    IAttachServiceRepository attachServiceRepository = new AttachServiceRepositoryImpl();
    @Override
    public Attach_service selectAttachService(int id) {
        return attachServiceRepository.selectAttachService(id);
    }
}
