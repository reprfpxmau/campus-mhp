package com.mhp.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * 风险评估实体类
 * INDEX: idx_student_id
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrRiskAssessment {
    //主键
    private Long assessmentId;
    // 学生ID
    private Long studentId;
    // 风险指数
    private Integer riskScore;
    // 风险等级：1=低 2=中 3=高
    private Integer riskLevel;
    // 触发规则
    private String triggerRule;
    //证据数据
    private String evidenceData;
    // 评估时间
    private LocalDateTime assessmentTime;
}
