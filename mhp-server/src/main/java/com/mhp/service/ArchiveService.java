package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ArchivePageQueryDTO;
import com.mhp.vo.MhArchiveVO;
import com.mhp.result.PageResult;
import com.mhp.entity.MhArchive;

@Service
public interface ArchiveService {
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ArchivePageQueryDTO archivePageQueryDTO);

    /**
     * 根据档案ID查询档案详情
     * @param id 档案ID
     * @return 档案详情
     */
    MhArchive selectById(Long id);

    /**
     * 根据学号查询档案详情
     * @param studentId 学生ID
     * @return 档案详情
     */
    MhArchiveVO selectByStudentId(Long studentId);

    /**
     * 更新档案
     * @param mhArchive 档案信息
     * @return
     */
    void update(MhArchive mhArchive);
}
