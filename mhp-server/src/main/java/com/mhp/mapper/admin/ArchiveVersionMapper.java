package com.mhp.mapper.admin;

import com.github.pagehelper.Page;
import com.mhp.dto.admin.ArchiveVersionPageQueryDTO;
import com.mhp.vo.admin.ArchiveVersionVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArchiveVersionMapper {
    Page<ArchiveVersionVO> pageQuery(ArchiveVersionPageQueryDTO dto);
}
