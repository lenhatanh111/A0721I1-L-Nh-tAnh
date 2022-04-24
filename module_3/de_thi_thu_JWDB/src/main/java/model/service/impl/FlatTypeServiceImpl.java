package model.service.impl;

import model.bean.FlatType;
import model.repository.IFlatTypeRepository;
import model.repository.impl.FlatTypeRepositoryImpl;
import model.service.IFlatTypeService;

import java.util.List;

public class FlatTypeServiceImpl implements IFlatTypeService {
    IFlatTypeRepository flatTypeRepository =new FlatTypeRepositoryImpl();
    @Override
    public List<FlatType> findAll() {
        return flatTypeRepository.findAll();
    }
}
