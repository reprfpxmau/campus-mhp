package com.mhp.controller.admin;

import com.mhp.dto.admin.OperationLogPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.OperationLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/admin/operation-log")
@Tag(name = "操作日志接口")
@Slf4j
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/page")
    @Operation(summary = "操作日志分页查询")
    public Result<PageResult> pageQuery(@ParameterObject OperationLogPageQueryDTO dto) {
        PageResult result = operationLogService.pageQuery(dto);
        return Result.success(result);
    }
}
