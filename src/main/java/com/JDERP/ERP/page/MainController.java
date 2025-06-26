package com.JDERP.ERP.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main() {
        return "main";  // templates/home.html
    }
}
