package com.JDERP.ERP.mapper;

import com.JDERP.ERP.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
}