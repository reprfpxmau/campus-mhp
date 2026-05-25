package com.mhp.controller.admin;

import com.mhp.vo.LoginVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mhp.common.result.Result;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/auth")
@Tag(name = "管理员相关接口")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    @Operation(summary = "管理员登录")
    public Result<LoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理员登录请求：{}", adminLoginDTO);
        LoginVO loginVO = adminService.login(adminLoginDTO).getData();
        return Result.success(loginVO);
    }
}
