package com.mhp.entity;

import lombok.Data;

/**
 * 题目实体类
 * INDEX: idx_archive_id
 */
@Data
public class PsyQuestion {
    // 主键
    private Long questionId;
    // 量表ID
    private Long scaleId;
    // 题号
    private Integer questionNo;
    // 题目内容
    private String content;
    // 是否反向计分:0=否 1=是
    private Integer isReverse;
    // 所属维度
    private String dimension;
}
