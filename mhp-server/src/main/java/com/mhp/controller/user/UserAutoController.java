package com.mhp.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mhp.dto.user.UserLoginDTO;
import com.mhp.result.Result;
import com.mhp.service.user.UserAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user/auth")
@Tag(name = "用户相关接口")
@Slf4j
public class UserAutoController {

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录请求：{} ", userLoginDTO);
        return userAuthService.login(userLoginDTO);
    }

    
}
