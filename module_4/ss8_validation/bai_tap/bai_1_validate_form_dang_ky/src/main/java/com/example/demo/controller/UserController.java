package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/create";
    }
    @PostMapping("")
    public String create(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            service.save(user);
            redirectAttributes.addFlashAttribute("message","create user"+user.getFirstName()+user.getLastName()+"OK!");
            return "/result";
        }
    }
}
