package com.mhp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public SysUser login(AdminLoginDTO adminLoginDTO) {
        String studentNo = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        SysUser admin = adminMapper.login(studentNo, password);
        if (admin == null) {
            return null;
        }
        log.info("管理员登录成功：{}", admin.getRealName());
        return admin;
    }
}
