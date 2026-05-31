package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.vo.ScaleVO;
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
    /**
     * 更新心理量表
     * @param psyScale 心理量表
     */
    void update(PsyScale psyScale);
    /**
     * 更新心理量表状态
     * @param status 状态：0=禁用 1=正常
     * @param scaleId 量表ID
     */
    void updateStatus(Integer status, Long scaleId);
    /**
     * 根据量表ID查询
     * @param scaleId 量表ID
     * @return 量表
     */
    ScaleVO selectById(Long scaleId);
}
