package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.ConsultService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springdoc.core.annotations.ParameterObject;  
import com.mhp.dto.admin.ConsultRecordDTO;
import com.mhp.dto.admin.ConsultDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/admin/consult")
@Tag(name = "咨询管理接口")
@Slf4j
public class ConsultController {
    @Autowired
    private ConsultService consultService;

    @Operation(summary = "分页查询咨询记录")
    @GetMapping("/page")
    public Result<PageResult> pageQuery(@ParameterObject ConsultDTO consultDTO) {
        return Result.success(consultService.pageQuery(consultDTO));
    }

    /**
     * 新增咨询记录
     * @param consultDTO
     */
    @Operation(summary = "新增咨询记录")
    @PostMapping
    public Result add(@RequestBody ConsultRecordDTO consultRecordDTO) {
        consultService.add(consultRecordDTO);
        return Result.success();
    }

}
