package com.mhp.entity;

import lombok.Data;
/**
 * 选项实体类
 * INDEX: idx_question_id
 */
@Data
public class PsyOption {
    // 主键
    private Long optionId;
    // 题目ID
    private Long questionId;
    // 选填编号(A/B/C/D)
    private String optionNo;
    // 选填文本
    private String optionText;
    // 对应分数
    private Integer score;
}
