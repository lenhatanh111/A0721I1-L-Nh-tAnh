package com.example.demo.controller;

import com.example.demo.dto.SelectAllCustomerDto;
import com.example.demo.repository.SelectAllCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private SelectAllCustomerRepository repository;
    @GetMapping("")
    public String home(){
        return "/index";
    }
    @GetMapping("/select")
    public String selectAllCustomer(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<SelectAllCustomerDto> selectAll=repository.getAllCustomerIsUsingService(pageable);
        model.addAttribute("customers",selectAll);
        return "/list";
    }
}
