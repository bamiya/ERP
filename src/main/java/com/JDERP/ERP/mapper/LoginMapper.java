package com.JDERP.ERP.mapper;

import com.JDERP.ERP.model.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Login login(@Param("userId") String userId,
                @Param("password") String password);
}
