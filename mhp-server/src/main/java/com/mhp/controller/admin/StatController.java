package com.mhp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import com.mhp.result.Result;
import com.mhp.service.admin.StatService;
import com.mhp.vo.admin.StatVO;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin/stat")
@Tag(name = "统计相关接口")
@Slf4j
public class StatController {
    @Autowired
    private StatService statService;

    //TODO 数据统计这一模块暂时不完善

    /**
     * 统计总览
     * @return
     */
    @GetMapping("/overview")
    public Result<StatVO> overview() {
        return statService.overview();
    }

    
}
