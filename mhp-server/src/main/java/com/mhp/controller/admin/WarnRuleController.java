package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.WarnRuleService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springdoc.core.annotations.ParameterObject;

import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.dto.admin.WarnRuleDTO;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

    @PutMapping
    @Operation(summary = "预警规则更新")
    public Result update(@RequestBody WarnRuleDTO warnRuleDTO) {
        log.info("预警规则更新请求：{}", warnRuleDTO);
        warnRuleService.update(warnRuleDTO);
        return Result.success();
    }

    /**
     * 预警规则状态更新
     * @param status
     * @param ruleId
     * @return
     */
    @PostMapping("status/{status}")
    @Operation(summary = "预警规则状态更新")
    public Result updateStatus(@PathVariable Integer status,Long id) {
        log.info("预警规则状态更新请求：{}, {}", status, id);
        warnRuleService.updateStatus(status, id);
        return Result.success();
    }

    @DeleteMapping("batch")
    @Operation(summary = "预警规则删除")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("预警规则删除请求：{}", ids);
        warnRuleService.deleteBatch(ids);
        return Result.success();
    }

}
