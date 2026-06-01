package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.WarnRuleService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springdoc.core.annotations.ParameterObject;

import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.dto.admin.WarnRuleDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin/warn-rule")
@Tag(name = "预警规则管理接口")
@Slf4j
public class WarnRuleController {
    @Autowired
    private WarnRuleService warnRuleService;
    /**
     * 预警规则分页查询
     * @param warnRulePageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @Operation(summary = "预警规则分页查询")
    public Result<PageResult> page(@ParameterObject RequestPageDTO requestPageDTO) {
        log.info("预警规则分页查询请求：{}", requestPageDTO);
        PageResult pageResult = warnRuleService.pageQuery(requestPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 预警规则新增
     * @param warnRuleDTO
     * @return
     */
    @PostMapping
    @Operation(summary = "预警规则新增")
    public Result add(@RequestBody WarnRuleDTO warnRuleDTO) {
        log.info("预警规则新增请求：{}", warnRuleDTO);
        warnRuleService.add(warnRuleDTO);
        return Result.success();
    }
}
