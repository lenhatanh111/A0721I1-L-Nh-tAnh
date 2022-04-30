package com.codegym.controller;

import com.codegym.entity.Mailbox;
import com.codegym.service.IServiceMailbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MaiboxController {

    @Autowired
   private IServiceMailbox serviceMailbox;
@GetMapping("/list")
private String form(Model model){
String[] languages={"English","Vietnamese","Chinese","Japanese"};
String[] pageSizes={"5","10","15","20","25","50","100"};

        model.addAttribute("mailbox",new Mailbox());
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        return "/index";
    }
    @GetMapping("")
    private String view(Model model){
        List<Mailbox> mailboxes=serviceMailbox.findAll();
        model.addAttribute("mailbox",mailboxes);
        return "/view";

    }
    @PostMapping("/update")
    private String save(@ModelAttribute("mailbox") Mailbox mailbox){
        serviceMailbox.update(mailbox);
        return "redirect:/";
    }

}
