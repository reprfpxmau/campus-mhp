package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ArchivePageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface ArchiveService {
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ArchivePageQueryDTO archivePageQueryDTO);
}
