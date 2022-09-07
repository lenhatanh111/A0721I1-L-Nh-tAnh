package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository repository;
    @Override
    public Page<Student> getAll(Pageable pageable) {
        return repository.fidAll(pageable);
    }

    @Override
    public void save(Student student) {
repository.save(student);
    }

    @Override
    public void delete(int id) {
Student student=repository.findById(id);
if (student!=null){
repository.delete(student);
}

    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        List<Student>students=repository.findAll();
        return students;
    }

//    @Override
//    public Optional<Student> getById(int id) {
//        return Optional.empty();
//    }
}
