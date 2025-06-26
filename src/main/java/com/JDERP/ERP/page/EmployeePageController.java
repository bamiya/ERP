package com.JDERP.ERP.page;

import com.JDERP.ERP.model.Employee;
import com.JDERP.ERP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeePageController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/page")
    public String employeePage(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee";  // resources/templates/employee.html
    }
}
