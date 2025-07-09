package com.JDERP.ERP.controller;

import com.JDERP.ERP.dto.LoginRequestDto;
import com.JDERP.ERP.mapper.LoginMapper;
import com.JDERP.ERP.model.Employee;
import com.JDERP.ERP.model.Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login"; // login.html
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequestDto loginDto, HttpSession session, Model model) {
        Login loginUser = loginMapper.login(
                loginDto.getUserId(),
                loginDto.getPassword()
        );
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return "redirect:/main";
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "auth/forgot-password";
    }
}
