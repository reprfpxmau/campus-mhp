package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.entity.SysUser;
import com.mhp.vo.UserVO;



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
    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    void update(SysUser sysUser);
    /**
     * 启用/禁用用户
     * @param status
     * @param userId
     * @return
     */
    void updateStatus(Integer status,Long userId);
    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    UserVO getDetail(Long userId);
}
