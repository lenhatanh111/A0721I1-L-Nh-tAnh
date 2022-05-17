package com.example.demo.service;

import com.example.demo.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibraryService {
    Page<Library> getAllLibrary(Pageable pageable);
}
