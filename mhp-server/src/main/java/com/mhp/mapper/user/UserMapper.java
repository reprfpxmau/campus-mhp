package com.mhp.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import com.mhp.entity.SysUser;
import com.mhp.entity.MhArchive;

@Mapper
public interface UserMapper {

    /*用户登录
     * @param loginDTO 登录参数
     */
    SysUser login(String studentNo);

    /**
     * 注册用户
     */
    void insert(SysUser user);
    /**
     * 新增档案档案
     */
    void newMhArchive(MhArchive mhArchive);
}
