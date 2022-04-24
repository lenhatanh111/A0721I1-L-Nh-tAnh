package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/convert")
    public String convert(@RequestParam double rate, @RequestParam double usd, Model model){
        double convert = rate*usd;
        model.addAttribute("convert",convert);
        return "view/convert";
    }

}
