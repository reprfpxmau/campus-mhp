package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mhp.dto.admin.AdminLoginDTO;
import com.mhp.result.Result;
import com.mhp.service.admin.AdminAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/auth")
@Tag(name = "管理员相关接口")
@Slf4j
public class AdminAutoController {

    @Autowired
    private AdminAuthService adminAuthService;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "管理员登录")
    public Result login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理员登录请求：{} ", adminLoginDTO);
        return adminAuthService.login(adminLoginDTO);
    }

    
}
