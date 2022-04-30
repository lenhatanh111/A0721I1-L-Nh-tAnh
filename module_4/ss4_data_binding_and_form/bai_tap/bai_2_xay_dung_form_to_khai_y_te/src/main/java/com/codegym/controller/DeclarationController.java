package com.codegym.controller;

import com.codegym.entity.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/declaration")
public class DeclarationController {
    @Autowired
    private IDeclarationService service;
    @GetMapping("/list")
    private String list(Model model){
        List<Declaration> declarations=service.findAll();
        model.addAttribute("declarations",declarations);
        return "/list";
    }
    @GetMapping("/create")
    private String createForm(Model model){
        String[] birthday={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
        String[] nationality={"Viet Nam","China","Thailand","USA","Japan","Korea"};
        String[] start_day={"1","2","3","4","5","6","7","8","9"};
        String[] start_year={"2020","2021","2022"};
        String[] start_month={"1","2","3","4","5","6","7","8","9"};
        String[] end_day={"1","2","3","4","5","6","7","8","9"};
        String[] end_month={"1","2","3","4","5","6","7","8","9"};
        String[] end_year={"2020","2021","2022"};
        model.addAttribute("declaration",new Declaration());
        model.addAttribute("birthday",birthday);
        model.addAttribute("nationality",nationality);
        model.addAttribute("start_day",start_day);
        model.addAttribute("start_month",start_month);
        model.addAttribute("start_year",start_year);
        model.addAttribute("end_day",end_day);
        model.addAttribute("end_month",end_month);
        model.addAttribute("end_year",end_year);
        return "/create";

    }
    @PostMapping("create")
    private String save(@ModelAttribute("declaration") Declaration declaration){
        service.create(declaration);
        return "redirect:/declaration/list";
    }
    @GetMapping("/update")
    private String updateForm(@RequestParam("id") String id, Model model){
        String[] birthday={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
        String[] nationality={"Viet Nam","China","Thailand","USA","Japan","Korea"};
        String[] start_day={"1","2","3","4","5","6","7","8","9"};
        String[] start_year={"2020","2021","2022"};
        String[] start_month={"1","2","3","4","5","6","7","8","9"};
        String[] end_day={"1","2","3","4","5","6","7","8","9"};
        String[] end_month={"1","2","3","4","5","6","7","8","9"};
        String[] end_year={"2020","2021","2022"};
        model.addAttribute("declaration",service.findByID(id));
        model.addAttribute("birthday",birthday);
        model.addAttribute("nationality",nationality);
        model.addAttribute("start_day",start_day);
        model.addAttribute("start_month",start_month);
        model.addAttribute("start_year",start_year);
        model.addAttribute("end_day",end_day);
        model.addAttribute("end_month",end_month);
        model.addAttribute("end_year",end_year);
        return "/update";
    }
    @PostMapping("/update")
    private String saveUpdate(@ModelAttribute("declaration") Declaration declaration){
        service.update(declaration);
        return "redirect:/declaration/list";
    }
}
