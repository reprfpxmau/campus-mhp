package com.mhp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 测评预警阈值实体类
 * INDEX: idx_scale_id
 */
@Data
public class PsyWarnThreshold {
    // 主键
    private Long thresholdId;
    // 量表ID
    private Long scaleId;
    // 阀值类型:1=总分 2=维度分数
    private String thresholdType;
    // 阈值数值
    private BigDecimal thresholdValue;
    // 对应风险等级
    private Integer riskLevel;
}
