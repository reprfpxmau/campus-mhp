package com.mhp.controller.user;

import com.mhp.dto.admin.ConsultDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.user.UserConsultService;
import com.mhp.vo.admin.ConsultPageQueryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/user/consult")
@Tag(name = "用户端-咨询记录接口")
@Slf4j
public class UserConsultController {
    @Autowired
    private UserConsultService userConsultService;

    @GetMapping("/my-records")
    @Operation(summary = "我的咨询记录")
    public Result<PageResult> myRecords(@ParameterObject ConsultDTO dto) {
        PageResult result = userConsultService.myRecords(dto);
        return Result.success(result);
    }

    @GetMapping("/record/{id}")
    @Operation(summary = "咨询记录详情")
    public Result<ConsultPageQueryVO> detail(@PathVariable Long id) {
        ConsultPageQueryVO vo = userConsultService.getDetail(id);
        return Result.success(vo);
    }
}
