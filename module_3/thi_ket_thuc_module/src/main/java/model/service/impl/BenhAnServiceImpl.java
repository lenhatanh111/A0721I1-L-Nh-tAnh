package model.service.impl;

import model.bean.BenhAn;
import model.repository.IBenhAnRepository;
import model.repository.impl.BenhAnRepositoryImpl;
import model.service.IBenhAnService;

import java.util.List;

public class BenhAnServiceImpl implements IBenhAnService {
    IBenhAnRepository benhAnRepository =new BenhAnRepositoryImpl();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }
}
