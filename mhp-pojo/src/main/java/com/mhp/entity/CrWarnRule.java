package com.mhp.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * 预警规则实体类
 * INDEX: idx_rule_name, idx_data_source
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrWarnRule {
    // 主键
    private Long ruleId;
    // 触则名称
    private String ruleName;
    // 数据源(如EXAM)
    private String dataSource;
    // 触发条件表达式
    private String conditionExpr;
    // 预警级别：1=低 2=中 3=高
    private Integer riskLevel;
    // 通知对象
    private String notifyTargets;
    // 规则状态：0=禁用 1=启用
    private Integer status;
    // 版本号
    private Integer version;
    // 创建时间
    private LocalDateTime createTime;
}
