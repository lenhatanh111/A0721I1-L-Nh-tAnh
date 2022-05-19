package com.example.demo.service;

import com.example.demo.exception.UserException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryService libraryService;

    @Override
    public void save(Book book) {
        List<Library> libraries = libraryService.findAll();
        for (Library l : libraries) {
            if (l.getName().equals(book.getTitle())) {
                book.setLibrary(l);
                bookRepository.save(book);
                return;
            } else {
                Library library = new Library();
                library.setName(book.getTitle());
                libraryService.save(library);
                book.setLibrary(library);
                bookRepository.save(book);
                return;
            }
        }

    }

    @Override
    public Page<Book> getAllBook(int id, Pageable pageable) {
        return bookRepository.getAllBook(id, pageable);
    }

//    @Override
//    public void updateLibraryId(String title) {
//        bookRepository.updateLibraryId(title);
//    }

    @Override
    public void giveBack(int id) throws Exception {
        if (!bookRepository.existsById(id)) {
            throw new UserException("Your code is valid");
        }
        if (bookRepository.getById(id).isStatus() == true) {
            throw new UserException("This book has not been borrowed");
        } else {
            Book book = bookRepository.getById(id);
            book.setStatus(true);
            bookRepository.save(book);
        }
    }

    @Override
    public void borrowBook(int id) {
        Book book = bookRepository.getById(id);
        book.setStatus(false);
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.getById(id);
    }


}
