package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.dto.admin.AdminLoginDTO;
import com.mhp.result.Result;
import com.mhp.vo.admin.LoginVO;
@Service
public interface AdminAuthService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Result<LoginVO> login(AdminLoginDTO adminLoginDTO);

}
