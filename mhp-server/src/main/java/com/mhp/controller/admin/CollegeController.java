package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.mhp.result.Result;
import com.mhp.entity.SysCollege;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import com.mhp.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/admin/college")
@Tag(name = "学院相关接口")
@Slf4j
public class CollegeController {
    @Autowired
    private CollegeService collegeService;



    /**
     * 查询学院
     * @param collegePageQueryDTO
     * @return
     */
    @GetMapping("/list")
    public Result<List<SysCollege>> list(){
        log.info("查询学院");  
        List<SysCollege> list = collegeService.list();
        return Result.success(list);

    }
}