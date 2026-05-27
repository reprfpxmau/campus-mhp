package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.MhArchive;
import com.mhp.dto.ArchivePageQueryDTO;

@Mapper
public interface ArchiveMapper {
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<MhArchive> pageQuery(ArchivePageQueryDTO archivePageQueryDTO);
}
