package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.mhp.result.Result;
import com.mhp.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.service.ScaleService;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.entity.PsyScale;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/admin/scale")
@Tag(name = "心理量表相关接口")
@Slf4j
public class ScaleController {
    @Autowired
    private ScaleService scaleService;
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @GetMapping("page")
    public Result<PageResult> page(@ParameterObject ScalePageQueryDTO scalePageQueryDTO) {
        log.info("分页查询心理量表：{}", scalePageQueryDTO);
        PageResult pageResult = scaleService.pageQuery(scalePageQueryDTO);
        return Result.success(pageResult);
    }
    
    /**
     * 新增量表
     * @param psyScale
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PsyScale psyScale) {
        log.info("新增心理量表：{}", psyScale);
        scaleService.add(psyScale);
        return Result.success();
    }

    /**
     * 更新心理量表
     * @param psyScale
     * @return
     */
    @PutMapping
    public Result update(@RequestBody PsyScale psyScale) {
        log.info("更新心理量表：{}", psyScale);
        scaleService.update(psyScale);
        return Result.success();
    }

    /**
     * 启用/禁用心理量表
     * @param status 状态：0=禁用 1=正常
     * @param scaleId 量表ID
     * @return 量表
     */
    @PostMapping("/status/{status}")
    public Result status(@PathVariable Integer status,Long id) {
        log.info("启用/禁用心理量表：status={}, id={}", status, id);
        scaleService.updateStatus(status, id);
        return Result.success();
    }
}
