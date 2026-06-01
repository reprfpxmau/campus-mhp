package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.mhp.result.Result;
import com.mhp.service.admin.CounselorService;
import com.mhp.vo.admin.CounselorPageQueryVO;

@RestController
@RequestMapping("/admin/counselor")
@Tag(name = "咨询师相关接口")
@Slf4j
public class CounselorController{
    @Autowired
    private CounselorService counselorService;

    /**
     * 分页查询咨询师
     * @param counselorPageQueryDTO
     * @return
     */
    @GetMapping("/list")
public Result<List<CounselorPageQueryVO>> list() { 
    List<CounselorPageQueryVO> counselorList = counselorService.list();
    return Result.success(counselorList);
}
}
