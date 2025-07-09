package com.JDERP.ERP.mapper;

import com.JDERP.ERP.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> selectEmployeeList();
}