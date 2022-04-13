package model.service.impl;

import model.bean.Education_degree;
import model.repository.IEducationDegreeRepository;
import model.repository.impl.EducationDegreeRepositoryImpl;
import model.service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository =new EducationDegreeRepositoryImpl();
    @Override
    public List<Education_degree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
