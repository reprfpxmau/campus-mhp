package com.mhp.controller.user;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.user.UserAppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/user/appointment")
@Tag(name = "用户端-预约接口")
@Slf4j
public class UserAppointmentController {
    @Autowired
    private UserAppointmentService userAppointmentService;

    @GetMapping("/my")
    @Operation(summary = "我的预约列表")
    public Result<PageResult> my(@ParameterObject AppointmentPageQueryDTO dto) {
        PageResult result = userAppointmentService.myAppointments(dto);
        return Result.success(result);
    }

    @PostMapping("/cancel/{id}")
    @Operation(summary = "取消预约")
    public Result cancel(@PathVariable Long id) {
        userAppointmentService.cancel(id);
        return Result.success();
    }
}
