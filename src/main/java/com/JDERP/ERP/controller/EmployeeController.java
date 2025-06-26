package com.JDERP.ERP.controller;

import com.JDERP.ERP.mapper.EmployeeMapper;
import com.JDERP.ERP.model.Employee;
import com.JDERP.ERP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }
}