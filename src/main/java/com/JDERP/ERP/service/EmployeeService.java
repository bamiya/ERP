package com.JDERP.ERP.service;

import com.JDERP.ERP.mapper.EmployeeMapper;
import com.JDERP.ERP.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    public List<Employee> selectEmployeeList() {
        return employeeMapper.selectEmployeeList();
    }
}
