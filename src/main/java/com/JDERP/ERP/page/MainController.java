package com.JDERP.ERP.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("content", "pages/main");
        return "layout";
    }
}
