package com.mhp.mapper;

import com.mhp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.UserPageQueryDTO;


@Mapper
public interface AdminMapper {
    /**
     * 管理员登录
     * @param studentNo
     * @return
     */
    SysUser login(String studentNo);

}
