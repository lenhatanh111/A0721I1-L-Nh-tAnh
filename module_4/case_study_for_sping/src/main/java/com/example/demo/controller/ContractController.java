package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService service;
    @GetMapping("")
    public String selectAllContract(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<Contract> contracts=service.findAll(pageable);
        model.addAttribute("contracts",contracts);
        return "contractList";
    }
}
