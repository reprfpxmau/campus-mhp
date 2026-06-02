package com.mhp.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import com.mhp.entity.SysUser;

@Mapper
public interface UserMapper {

    /*用户登录
     * @param loginDTO 登录参数
     */
    SysUser login(String studentNo);
}
