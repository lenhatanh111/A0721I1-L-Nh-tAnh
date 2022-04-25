package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("")
    public String Calculation() {

        return  "/index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String condiment, ModelMap model) {
        model.addAttribute("condiment", condiment);
        return "views/list";
    }


}
