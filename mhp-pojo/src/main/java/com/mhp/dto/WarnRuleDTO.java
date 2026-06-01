package com.mhp.dto;

import lombok.Data;

@Data
public class WarnRuleDTO {
    // 预警规则ID
    private Long ruleId;
    // 预警规则名称
    private String ruleName;
    // 数据源
    private String dataSource;
    // 预警规则表达式
    private String conditionExpr;
    // 风险等级
    private Integer riskLevel;
    // 通知目标
    private String notifyTargets;
}
