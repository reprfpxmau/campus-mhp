package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhp.dto.ExamPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.service.ExamService;



/**
 * 测评记录
 */
@RestController
@RequestMapping("/admin/exam")
@Tag(name = "测评记录相关接口")
@Slf4j
public class ExamController {
    @Autowired
    private ExamService examService;
    
    /**
     * 测评记录分页查询
     * @param examRecordPageQueryDTO
     * @return
     */
    @GetMapping("page")
    public Result<PageResult> page(@ParameterObject ExamPageQueryDTO examPageQueryDTO) {
        log.info("测评记录分页查询请求：{}", examPageQueryDTO);
        PageResult pageResult = examService.pageQuery(examPageQueryDTO);
        return Result.success(pageResult);
    }
    
}
