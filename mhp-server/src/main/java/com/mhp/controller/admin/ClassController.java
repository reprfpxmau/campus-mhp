package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import com.mhp.service.ClassService;
import com.mhp.entity.SysClass;
import com.mhp.result.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin/class")
@Tag(name = "班级相关接口")
@Slf4j
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 查询班级
     * @param collegeId 学院ID
     * @return 班级列表
     */
    @GetMapping("/list")
    public Result<List<SysClass>> list(Long collegeId) {
        log.info("根据学院ID查询班级列表，学院ID：{}",collegeId);
        List<SysClass> list = classService.list(collegeId);
        return Result.success(list);
    }
}
