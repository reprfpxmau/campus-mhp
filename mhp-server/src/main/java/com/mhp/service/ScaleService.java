package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.entity.PsyScale;

@Service
public interface ScaleService {
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ScalePageQueryDTO scalePageQueryDTO);
    /**
     * 新增心理量表
     * @param psyScale 心理量表
     */
    void add(PsyScale psyScale);

}
