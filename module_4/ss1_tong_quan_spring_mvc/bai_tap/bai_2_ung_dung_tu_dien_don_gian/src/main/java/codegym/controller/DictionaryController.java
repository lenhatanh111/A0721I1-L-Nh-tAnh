package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String dict(@RequestParam String search, Model model){
        Map<String, String> dic = new HashMap<>();
        dic.put("hello","xin chao");
        dic.put("how","the nao");
        dic.put("book","quyen vo");
        dic.put("computer","may tinh");
        String result = dic.get(search);
        model.addAttribute("search",search);
        model.addAttribute("result",result);
        if (model==null){
            String notfound = "Not found";
            model.addAttribute("notfound",notfound);
        }
        return "view/dictionary";
    }
}
