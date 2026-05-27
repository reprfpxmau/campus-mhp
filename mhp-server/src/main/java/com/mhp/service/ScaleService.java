package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface ScaleService {
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ScalePageQueryDTO scalePageQueryDTO);
    

}
