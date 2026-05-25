package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.service.AdminService;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/admin/user")
@Tag(name = "用户管理接口")
@Slf4j
public class UserController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/page")
    @Operation(summary = "用户分页查询")
    public Result<PageResult> page(@ParameterObject UserPageQueryDTO userPageQueryDTO) {
        log.info("用户分页查询请求：{}", userPageQueryDTO);
        PageResult pageResult = adminService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

    
}
