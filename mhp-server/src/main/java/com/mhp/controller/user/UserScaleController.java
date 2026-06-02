package com.mhp.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;  
import com.mhp.result.Result;
import com.mhp.entity.PsyScale;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.service.user.UserScaleService;
import java.util.List;



@RestController
@RequestMapping("/user/scale")
@Tag(name = "用户测试相关接口")
@Slf4j
public class UserScaleController {
    @Autowired
    private UserScaleService userScaleService;
    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    @GetMapping("/available")
    public Result<List<PsyScale>> available() {
        Result<List<PsyScale>> psyScale = userScaleService.scaleList();
        return psyScale;
    }
}
