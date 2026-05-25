package com.mhp.service;

import org.springframework.stereotype.Service;

import com.mhp.result.Result;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.vo.LoginVO;

@Service
public interface AdminService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Result<LoginVO> login(AdminLoginDTO adminLoginDTO);
}
