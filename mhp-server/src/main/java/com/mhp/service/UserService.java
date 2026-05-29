package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.entity.SysUser;


@Service
public interface UserService {
    /**
     * 用户分页查询
     * @param userPageQueryDTO
     * @return
     */
    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    void add(SysUser sysUser);
}
