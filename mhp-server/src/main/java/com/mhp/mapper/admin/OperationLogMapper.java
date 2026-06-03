package com.mhp.mapper.admin;

import com.github.pagehelper.Page;
import com.mhp.dto.admin.OperationLogPageQueryDTO;
import com.mhp.vo.admin.OperationLogVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {
    Page<OperationLogVO> pageQuery(OperationLogPageQueryDTO dto);
}
