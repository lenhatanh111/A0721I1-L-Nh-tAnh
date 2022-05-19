package com.example.demo.controller;

import com.example.demo.exception.UserException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}/view")
    public String showBook(@PathVariable int id, @PageableDefault(size = 3, sort = {"title"}, direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Book> books = bookService.getAllBook(id, pageable);
        model.addAttribute("books", books);
        return "/bookList";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
//        Book book=new Book();
//        book.setLibrary(new Library());
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:";

    }

    @GetMapping("/{bookId}/borrow")
    public String borrowBook(@PathVariable int bookId, Model model) {
        bookService.borrowBook(bookId);
        model.addAttribute("bookId", bookId);
        model.addAttribute("book", bookService.findById(bookId));
        return "/borrow";
    }

    @GetMapping("/back")
    public String showBackForm(Model model) {
        return "/back";
    }

    @PostMapping("/back")
    public String giveBack(@RequestParam("bookId") int bookId) throws Exception {
        bookService.giveBack(bookId);

        return "redirect:/";
    }

    @ExceptionHandler(UserException.class)
    public String errorHandler(UserException e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Book controller============");
        return "/back";
    }


}
