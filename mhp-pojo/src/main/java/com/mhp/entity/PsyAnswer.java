package com.mhp.entity;

import lombok.Data;
/**
 * 答题记录实体类
 * INDEX: idx_record_question (record_id, question_id)
 */
@Data
public class PsyAnswer {
    // 主键
    private Long answerId;
    // 记录ID
    private Long recordId;
    // 题目ID
    private Long questionId;
    // 选项ID
    private Long optionId;
    // 对应分数
    private Integer score;
}
