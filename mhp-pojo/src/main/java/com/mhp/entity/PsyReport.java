package com.mhp.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 测评报告实体类
 * INDEX: idx_student_id
 */
@Data
public class PsyReport {
    // 主键
    private Long reportId;
    // 记录ID
    private Long recordId;
    // 学生ID
    private Long studentId;
    // 量表ID
    private Long scaleId;
    // 总分
    private BigDecimal totalScore;
    // 结果等级:0=正常 1=轻度 2=中度 3=重度
    private Integer resultLevel;
    // 各维度分数
    private String dimensionScores;
    // 结果解释
    private String interpretation;
    // 建议
    private String suggestions;
    // 报告文件url
    private String reportUrl;
    // 生成时间
    private LocalDateTime generateTime;
}
