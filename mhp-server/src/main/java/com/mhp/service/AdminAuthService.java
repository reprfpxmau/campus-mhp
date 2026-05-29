package com.mhp.service;

import org.springframework.stereotype.Service;

import com.mhp.result.Result;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.vo.LoginVO;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface AdminAuthService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Result<LoginVO> login(AdminLoginDTO adminLoginDTO);

}
