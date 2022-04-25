package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class CalculatorController {
    @GetMapping("")
    public String Calculation() {

        return  "/index";
    }

    @RequestMapping("/calculator")
    public String save(@RequestParam int parameters1,@RequestParam int parameters2,@RequestParam String calculation,ModelMap model) {
        int result=0;
        if (calculation.equals("add")){
            result=parameters1+parameters2;
        }else if(calculation.equals("sub")){
            result=parameters1-parameters2;
        }else if(calculation.equals("mul")){
            result=parameters1*parameters2;
        }else result=parameters1/parameters2;
        model.addAttribute("result", result);
        return "views/list";
    }


}
