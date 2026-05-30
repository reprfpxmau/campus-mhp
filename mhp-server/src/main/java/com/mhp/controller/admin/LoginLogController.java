package com.mhp.controller.admin;

import com.mhp.dto.AdminLoginLogDTO;
import com.mhp.service.LoginLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/admin/login-log")
@Tag(name = "登录日志相关接口")
@Slf4j
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;

    /**
     * 分页查询登录日志
     * @param adminLoginLogDTO 分页查询参数
     * @return 分页结果
     */
    @GetMapping("/page")
    public Result<PageResult> pageQuery(@ParameterObject AdminLoginLogDTO adminLoginLogDTO) {
        PageResult pageResult = loginLogService.pageQuery(adminLoginLogDTO);
        return Result.success(pageResult);
    }
}
