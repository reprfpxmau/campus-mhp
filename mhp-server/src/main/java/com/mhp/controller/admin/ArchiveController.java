package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mhp.dto.ArchivePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.service.ArchiveService;
import com.mhp.result.Result;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.entity.MhArchive;
import org.springframework.web.bind.annotation.RequestBody;



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
    
    /**
     * 根据档案ID查询档案详情
     * @param archiveId
     * @return
     */
    @GetMapping("/{id}")
    public Result<MhArchive> detail(@PathVariable Long id) {
        log.info("根据档案ID查询档案详情：{}", id);
        MhArchive mhArchive = archiveService.selectById(id);
        return Result.success(mhArchive); 
    }
    /**
     * 根据学号查询档案详情
     * @param studentId
     * @return
     */
    @GetMapping("/student/{studentId}")
    public Result<MhArchive> detailByStudentId(@PathVariable Long studentId) {
        log.info("根据学号查询档案详情：{}", studentId);
        MhArchive mhArchive = archiveService.selectByStudentId(studentId);
        return Result.success(mhArchive); 
    }


    /**
     * 编辑档案
     * @param mhArchive
     * @return
     */
    @PostMapping
    public Result update(@RequestBody MhArchive mhArchive) {
        log.info("编辑档案：{}", mhArchive);
        archiveService.update(mhArchive);
        return Result.success();
    }
}
