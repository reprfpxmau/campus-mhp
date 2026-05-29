package com.mhp.mapper;

import com.github.pagehelper.Page;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import com.mhp.vo.UserPageQueryVO;

@Mapper
public interface UserMapper {
    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    Page<UserPageQueryVO> pageQuery(UserPageQueryDTO userPageQueryDTO);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);
}
