package com.mhp.service.admin;

import com.mhp.dto.admin.AdminLoginLogDTO;
import com.mhp.result.PageResult;

import org.springframework.stereotype.Service;

@Service
public interface LoginLogService {
    /**
     * 分页查询登录日志
     * @param adminLoginLogDTO
     * @return
     */
    PageResult pageQuery(AdminLoginLogDTO adminLoginLogDTO);
}
