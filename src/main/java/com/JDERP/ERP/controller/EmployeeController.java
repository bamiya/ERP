package com.JDERP.ERP.controller;

import com.JDERP.ERP.model.Employee;
import com.JDERP.ERP.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // 1) 페이지 호출 → templates/pages/employee.html 렌더링
    @GetMapping
    public String showEmployeePage(Model model) {
        model.addAttribute("content", "pages/employee"); // ← fragment 위치
        return "layout"; // ← 전체 layout 템플릿
    }

    // 2) AJAX용 데이터 API → JSON 반환
    @GetMapping("/list")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        return employeeService.selectEmployeeList();
    }
}
