package com.JDERP.ERP.service;

import com.JDERP.ERP.mapper.EmployeeMapper;
import com.JDERP.ERP.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeMapper.selectAll();
    }
}
