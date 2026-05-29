package com.mhp.mapper;

import com.github.pagehelper.Page;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    Page<SysUser> pageQuery(UserPageQueryDTO userPageQueryDTO);
}
