package com.mhp.controller.admin;

import com.mhp.common.Result;
import com.mhp.vo.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.service.AdminService;
import com.mhp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin/auth")
@Api(tags = "管理员相关接口")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理员登录请求：{}", adminLoginDTO);
        SysUser admin = adminService.login(adminLoginDTO);
        String token = jwtUtil.createToken(admin.getStudentNo(), "admin");
        return Result.success(new LoginVO(token, admin));   
    }
}
