package com.mhp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mhp.result.Result;
import com.mhp.constant.MessageConstant;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.service.AdminService;
import com.mhp.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.mapper.AdminMapper;
import com.mhp.vo.LoginVO;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Result<LoginVO> login(AdminLoginDTO adminLoginDTO) {
        String studentNo = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();   
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        
        SysUser admin = adminMapper.login(studentNo);
        if (admin == null) {
            return Result.error(MessageConstant.USERNAME_NULL);
        }
        if(!admin.getPassword().equals(password)){
            return Result.error(MessageConstant.PASSWORD_ERROR);
        }
        String token = jwtUtil.createToken(admin.getUserId(), "admin");

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserInfo(admin);
        log.info("管理员登录成功：{}", admin.getRealName());
        return Result.success(loginVO);
    }
}
