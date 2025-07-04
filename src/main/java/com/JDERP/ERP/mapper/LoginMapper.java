package com.JDERP.ERP.mapper;

import com.JDERP.ERP.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Employee login(@Param("emp_cd") String empCd, @Param("password") String password);
}
