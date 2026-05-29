package com.mhp.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.result.Result;
import com.mhp.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springdoc.core.annotations.ParameterObject;
import com.mhp.result.PageResult;

/**
 * 预警控制器
 */
@RestController
@RequestMapping("/admin/warn")
@Tag(name = "预警相关接口")
@Slf4j
public class WarnController {
    @Autowired
    private WarnService warnService;

    /**
     * 分页查询预警
     * @param warnPageQueryDTO
     * @return
     */
    @GetMapping("page")
    @Operation(summary = "预警分页查询")
    public Result<PageResult> page(@ParameterObject WarnPageQueryDTO warnPageQueryDTO) {
        log.info("分页查询预警请求：{}", warnPageQueryDTO);
        PageResult pageResult = warnService.pageQuery(warnPageQueryDTO);
        return Result.success(pageResult);
    }

        
    /**
     * 预警评估详情
     * @param assessmentId
     * @return
     */
    @GetMapping("/detail/{assessmentId}")
    public Result<PageResult> getDetail(@PathVariable String assessmentId) {
        log.info("预警评估详情请求：{}", assessmentId);
        PageResult pageResult = warnService.getDetail(assessmentId);
        return Result.success(pageResult);
    }
    
}
