package com.JDERP.ERP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LadderGameController {
    @GetMapping("/ladder")
    public String ladderGamePage() {
        return "ladder";
    }
}
