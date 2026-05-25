package com.mhp.service;

import org.springframework.stereotype.Service;

import com.mhp.result.Result;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.vo.LoginVO;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface AdminService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Result<LoginVO> login(AdminLoginDTO adminLoginDTO);
    /**
     * 用户分页查询
     * @param userPageQueryDTO
     * @return
     */
    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
}
