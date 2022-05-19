package com.example.demo.service;

import com.example.demo.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryService {
    Page<Library> getAllLibrary(Pageable pageable);

    List<Library> findAll();

    void save(Library library);
}
