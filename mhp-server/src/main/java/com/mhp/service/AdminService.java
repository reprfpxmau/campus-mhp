package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;

@Service
public interface AdminService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    SysUser login(AdminLoginDTO adminLoginDTO);
}
