package model.service.impl;

import common.Validation;
import model.bean.Flat;
import model.repository.IFlatRepository;
import model.repository.impl.FlatRepositoryImpl;
import model.service.IFlatService;

import java.util.ArrayList;
import java.util.List;

public class FlatServiceImpl implements IFlatService {
    IFlatRepository flatRepository= new FlatRepositoryImpl();
    @Override
    public List<Flat> findAll() {
        return flatRepository.findAll();
    }

    @Override
    public List<Flat> search(String flat_type_id, String start_date, String end_date, String floor) {
        return flatRepository.search(flat_type_id,start_date,end_date,floor);
    }

    @Override
    public boolean delete(String id) {
        return flatRepository.delete(id);
    }

    @Override
    public List<String> add(Flat flat) {
        boolean check=true;
        List<String> messList=new ArrayList<>();
        if (Validation.checkFlatID(flat.getFlat_id())){
            messList.add("");
        }else {
            check=false;
            messList.add("malformed flat ID");
        }
        if (Validation.checkExist(flat.getFlat_id())){
            messList.add("flat ID already exists");
            check=false;

        }else {

            messList.add("");
        }
        if (Validation.checkArea(flat.getArea())){
            messList.add("");
        }else {
            check=false;
            messList.add("the area must be more than 20 m2");
        }
        if (Validation.checkCost(flat.getCost())){
            messList.add("");
        }else {
            check=false;
            messList.add("the cost must be more than 1.000.000 VND");
        }
        if (Validation.checkDate(flat.getStart_date(),flat.getEnd_date())){
            messList.add("");
        }else {
            check=false;
            messList.add("The start date must be at least 6 months less than the end date");
        }
        if(check){
            flatRepository.add(flat);
        }
        return messList;
    }
}
