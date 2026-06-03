package com.mhp.controller.admin;

import com.mhp.dto.admin.ArchiveVersionPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.ArchiveVersionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/admin/archive-version")
@Tag(name = "档案版本接口")
@Slf4j
public class ArchiveVersionController {
    @Autowired
    private ArchiveVersionService archiveVersionService;

    @GetMapping("/page")
    @Operation(summary = "档案版本分页查询")
    public Result<PageResult> pageQuery(@ParameterObject ArchiveVersionPageQueryDTO dto) {
        PageResult result = archiveVersionService.pageQuery(dto);
        return Result.success(result);
    }
}
