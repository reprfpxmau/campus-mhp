package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springdoc.core.annotations.ParameterObject;
import com.mhp.dto.RequestPageDTO;
import com.mhp.service.WarnRuleService;

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
}
