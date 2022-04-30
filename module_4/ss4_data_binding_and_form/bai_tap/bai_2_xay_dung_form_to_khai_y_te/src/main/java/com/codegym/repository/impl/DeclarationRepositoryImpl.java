package com.codegym.repository.impl;

import com.codegym.entity.Declaration;
import com.codegym.repository.IDeclarationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeclarationRepositoryImpl implements IDeclarationRepository {
    private static Map<String,Declaration> declarationMap=new HashMap<>();
    static {
        declarationMap.put("D001",new Declaration("D001","Le Nhat Anh","2000-01-28",true,"Viet Nam","201864219","xe may","76Y22674","1","30","04","2022","01","05","2022","quang ngai den da nang"));
    }
    @Override
    public List<Declaration> findAll() {

        return new ArrayList<>(declarationMap.values());
    }

    @Override
    public void create(Declaration declaration) {
        if (!declarationMap.containsKey(declaration.getId())){
            declarationMap.put(declaration.getId(),declaration);
        }


    }

    @Override
    public void update(Declaration declaration) {
        if (declarationMap.containsKey(declaration.getId())){
            declarationMap.put(declaration.getId(),declaration);
        }
    }

    @Override
    public Declaration findByID(String id) {
        return declarationMap.get(id);
    }

}
