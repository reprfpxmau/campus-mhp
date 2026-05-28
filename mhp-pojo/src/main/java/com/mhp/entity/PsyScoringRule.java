package com.mhp.entity;

import lombok.Data;

/**
 * 测评评分规则实体类
 * INDEX: idx_scale_id
 */
@Data
public class PsyScoringRule {
    // 主键
    private Long ruleId;
    // 量表ID
    private Long scaleId;
    // 规则名称
    private String ruleName;
    // 规则类型:1=总分 2=维度分数
    private Integer ruleType;
    // 计算公式
    private String formula;
    // 常模数据
    private String normData;
}
