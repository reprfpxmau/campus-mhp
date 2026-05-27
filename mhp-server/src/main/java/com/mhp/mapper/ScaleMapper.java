package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.PsyScale;
import com.mhp.dto.ScalePageQueryDTO;

@Mapper
public interface ScaleMapper {
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<PsyScale> pageQuery(ScalePageQueryDTO scalePageQueryDTO);
}