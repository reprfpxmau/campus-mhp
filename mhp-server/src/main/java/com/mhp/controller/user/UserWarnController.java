package com.mhp.controller.user;

import com.mhp.context.BaseContext;
import com.mhp.dto.admin.WarnPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.WarnService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/user/warn")
@Tag(name = "用户端-预警接口")
@Slf4j
public class UserWarnController {
    @Autowired
    private WarnService warnService;

    @GetMapping("/my")
    @Operation(summary = "我的预警列表")
    public Result<PageResult> my(@ParameterObject WarnPageQueryDTO dto) {
        Long studentId = BaseContext.getCurrentId();
        dto.setStudentId(studentId);
        PageResult result = warnService.pageQuery(dto);
        return Result.success(result);
    }
}
