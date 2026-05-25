package com.mhp.mapper;

import com.mhp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    SysUser login(@Param("studentNo") String studentNo, @Param("password") String password);
}
