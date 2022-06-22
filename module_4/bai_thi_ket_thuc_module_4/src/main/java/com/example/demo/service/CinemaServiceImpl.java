package com.example.demo.service;

import com.example.demo.model.Cinema;
import com.example.demo.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService{
    @Autowired
    private CinemaRepository repository;
    @Override
    public void save(Cinema cinema) {
        repository.save(cinema);
    }

    @Override
    public void edit(Cinema cinema) {
        repository.save(cinema);
    }

    @Override
    public Cinema findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        Cinema cinema = repository.findById(id);
        if (cinema != null) {
            repository.delete(cinema);
        }
    }

    @Override
    public Page<Cinema> getAllCinema(String sale, String startDate, String endDate, Pageable pageable) {
        return repository.findAll(sale,startDate,endDate,pageable);
    }

    @Override
    public List<Cinema> findAllCinema() {
        return repository.findAll();
    }
}
