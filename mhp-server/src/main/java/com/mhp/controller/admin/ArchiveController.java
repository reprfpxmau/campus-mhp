package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import com.mhp.dto.ArchivePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.service.ArchiveService;
import com.mhp.result.Result;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin/archive")
@Tag(name = "档案相关接口")
@Slf4j
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    /**
     * 档案分页查询
     * @param archivePageQueryDTO
     * @return
     */
    @GetMapping("page")
    public Result<PageResult> page(@ParameterObject ArchivePageQueryDTO archivePageQueryDTO) {
        log.info("分页查询档案：{}", archivePageQueryDTO);
        PageResult pageResult = archiveService.pageQuery(archivePageQueryDTO);
        return Result.success(pageResult);
    }
    
}
