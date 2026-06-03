package com.mhp.controller.user;

import com.mhp.dto.user.BehaviorLogDTO;
import com.mhp.result.Result;
import com.mhp.service.user.BehaviorLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/behavior")
@Tag(name = "用户端-行为日志接口")
@Slf4j
public class BehaviorLogController {
    @Autowired
    private BehaviorLogService behaviorLogService;

    @PostMapping("/log")
    @Operation(summary = "上报行为事件")
    public Result report(@RequestBody BehaviorLogDTO dto) {
        log.info("上报行为事件：{}", dto);
        behaviorLogService.report(dto);
        return Result.success();
    }
}
