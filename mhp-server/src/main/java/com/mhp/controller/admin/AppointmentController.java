package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mhp.dto.AppointmentPageQueryDTO;
import com.mhp.result.Result;
import com.mhp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springdoc.core.annotations.ParameterObject;
import com.mhp.result.PageResult;

@RestController
@RequestMapping("/admin/appointment")
@Tag(name = "预约相关接口")
@Slf4j
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    @GetMapping("page")
    public Result<PageResult> page(@ParameterObject AppointmentPageQueryDTO appointmentPageQueryDTO) {
        log.info("分页查询预约请求：{}", appointmentPageQueryDTO);
        PageResult pageResult = appointmentService.pageQuery(appointmentPageQueryDTO);
        return Result.success(pageResult);
    }
    
}
