package com.example.demo.service;

import com.example.demo.model.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CinemaService {
    void save(Cinema cinema);

    void edit(Cinema cinema);

    Cinema findById(int id);

    void delete(int id);

    Page<Cinema> getAllCinema(String sale, String startDate,String endDate, Pageable pageable);

    List<Cinema> findAllCinema();
}
