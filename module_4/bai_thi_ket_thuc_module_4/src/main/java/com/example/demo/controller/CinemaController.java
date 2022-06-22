package com.example.demo.controller;

import com.example.demo.dto.CinemaDto;
import com.example.demo.model.Cinema;
import com.example.demo.service.CinemaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class CinemaController {
    @Autowired
    private CinemaService service;
    @GetMapping("")
    public String getAllCinema(@RequestParam(defaultValue = "0") String sale, @RequestParam(defaultValue = "") String startDate,@RequestParam(defaultValue = "") String endDate, @PageableDefault(size = 2) Pageable pageable, Model model){
        Page<Cinema> cinemas=service.getAllCinema(sale,startDate,endDate,pageable);
        model.addAttribute("sale",sale);
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        model.addAttribute("cinemas",cinemas);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("cinemaDto",new CinemaDto());
        return "/create";

    }
    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CinemaDto cinemaDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()){
            return "/create";}
        else {
            Cinema cinema = new Cinema();
            BeanUtils.copyProperties(cinemaDto, cinema);
            service.save(cinema);
            return "redirect:";}
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:";
    }
    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable int id, Model model){
        Cinema cinema=service.findById(id);
        CinemaDto cinemaDto=new CinemaDto();
        BeanUtils.copyProperties(cinema, cinemaDto);
        model.addAttribute("cinemaDto",cinemaDto);
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CinemaDto cinemaDto,BindingResult bindingResult,@RequestParam("id") int id){
        if (bindingResult.hasFieldErrors()){
            return "/edit";}
        else {
            Cinema cinema = service.findById(id);
            BeanUtils.copyProperties(cinemaDto, cinema);
            service.save(cinema);
            return "redirect:";
        }
    }

}
