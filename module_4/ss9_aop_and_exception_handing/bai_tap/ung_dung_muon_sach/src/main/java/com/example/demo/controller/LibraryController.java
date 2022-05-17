package com.example.demo.controller;

import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    @GetMapping("")
    public String getLibrary(@PageableDefault(size = 3, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable
            , Model model){
        model.addAttribute("libraries",libraryService.getAllLibrary(pageable));
        return "/list";
    }
}
