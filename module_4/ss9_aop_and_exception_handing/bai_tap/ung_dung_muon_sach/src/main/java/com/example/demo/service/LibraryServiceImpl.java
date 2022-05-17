package com.example.demo.service;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Override
    public Page<Library> getAllLibrary(Pageable pageable) {
        return libraryRepository.getAllLibrary(pageable);
    }
}
