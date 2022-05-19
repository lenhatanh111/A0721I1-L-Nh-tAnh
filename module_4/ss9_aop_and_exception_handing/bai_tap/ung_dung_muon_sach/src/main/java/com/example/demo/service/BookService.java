package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    //    void save( String author, boolean status,String title);
    void save(Book book);

    Page<Book> getAllBook(int id, Pageable pageable);

    //    void updateLibraryId(String title);
    void giveBack(int id) throws Exception;

    void borrowBook(int id);

    Book findById(int id);
}
