package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService service;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("musics", service.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("music") Music music) {
        service.create(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("music", service.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String edit(Music music) {
        service.update(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String ShowDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", service.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music) {
        service.delete(music.getId());
        return "redirect:/music";
    }

    @GetMapping("/{id}/listen")
    public String listen(@PathVariable int id, Model model) {
        model.addAttribute("music", service.findById(id));
        return "/listen";
    }
}
