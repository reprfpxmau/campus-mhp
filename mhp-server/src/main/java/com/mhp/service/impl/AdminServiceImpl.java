package com.mhp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mhp.common.result.Result;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.service.AdminService;
import com.mhp.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.mapper.AdminMapper;
import com.mhp.vo.LoginVO;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Result<LoginVO> login(AdminLoginDTO adminLoginDTO) {
        String password = adminLoginDTO.getPassword();
        SysUser admin = adminMapper.login(adminLoginDTO.getUsername(), password);
        if (admin == null || admin.getStudentNo() == null) {
            return Result.error("管理员账号或密码错误");
        }
        String token = jwtUtil.createToken(admin.getUserId(), "admin");
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserInfo(admin);
        log.info("管理员登录成功：{}", admin.getRealName());
        return Result.success(loginVO);
    }
}
