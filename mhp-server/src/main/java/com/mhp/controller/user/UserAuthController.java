package com.mhp.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户端认证控制器
 * TODO: 实现以下接口
 * - POST /user/auth/login     学生登录（学号+密码，返回Token）
 * - POST /user/auth/register  学生注册（学号+姓名+手机+密码，自动创建档案）
 * - POST /user/auth/logout    退出登录（清除Redis Token）
 * - PUT  /user/auth/password  修改密码（旧密码+新密码）
 *
 * 注意：咨询师也通过管理端登录（/admin/auth/login），不走此接口
 */
@RestController
@RequestMapping("/user/auth")
@Tag(name = "用户端-认证接口")
@Slf4j
public class UserAuthController {
    // TODO: 实现登录、注册、退出、修改密码
}
