package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public Page<Book> getAllBook(int id, Pageable pageable) {
        return bookRepository.getAllBook(id,pageable);
    }

//    @Override
//    public void updateLibraryId(String title) {
//        bookRepository.updateLibraryId(title);
//    }

    @Override
    public void giveBack(int id) {
        Book book=bookRepository.getById(id);
        book.setStatus(true);
        bookRepository.save(book);
    }

    @Override
    public void borrowBook(int id) {
Book book=bookRepository.getById(id);
book.setStatus(false);
bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.getById(id);
    }


}
