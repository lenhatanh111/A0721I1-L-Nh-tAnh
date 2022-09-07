package com.example.demo.service;

import com.example.demo.model.GroupClass;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private GroupRepository repository;

    @Override
    public List<GroupClass> getAll() {
        return repository.findAll();
    }
}
