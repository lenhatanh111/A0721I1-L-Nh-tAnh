package model.service.impl;

import model.bean.BenhNhan;
import model.repository.IBenhNhanRepository;
import model.repository.impl.BenhNhanRepositoryImpl;
import model.service.IBenhNhanService;

import java.util.ArrayList;
import java.util.List;

public class BenhNhanServiceImpl implements IBenhNhanService {
    IBenhNhanRepository benhNhanRepository=new BenhNhanRepositoryImpl();
    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public boolean edit(BenhNhan benhNhan) {

       return benhNhanRepository.edit(benhNhan);

    }

    @Override
    public boolean delete(String id) {
        return benhNhanRepository.delete(id);
    }

    @Override
    public BenhNhan findBenhNhanByID(String id) {
        return benhNhanRepository.findBenhNhanByID(id);
    }
}
