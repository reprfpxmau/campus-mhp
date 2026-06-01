package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.result.PageResult;
import com.mhp.vo.admin.ScaleVO;
import com.mhp.entity.PsyScale;
import com.mhp.dto.admin.ScalePageQueryDTO;
import com.mhp.entity.PsyQuestionDTO;
import java.util.List;

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
    /**
     * 新增题目
     * @param psyQuestionDTO 题目DTO
     */
    void addQuestion(PsyQuestionDTO psyQuestionDTO);
    /**
     * 删除题目
     * @param id 题目ID
     */
    void deleteQuestion(Long id);
    /**
     * 批量删除量表
     * @param scaleIds 量表ID列表
     */
    void batchDeleteScale(List<Long> scaleIds);
}
