package com.mhp.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 咨询摘要实体类
 * INDEX: idx_archive_id
 */
@Data
public class MhConsultSummary {
    // 主键
    private Long summaryId;
    // 档案ID
    private Long archiveId;
    // 咨询师ID
    private Long counselorId;
    // 咨询日期
    private LocalDate consultDate;
    // 咨询摘要(脱敏)
    private String summaryContent;
    // 风险评估
    private String riskAssessment;
    // 创建时间
    private LocalDateTime createTime;
}
