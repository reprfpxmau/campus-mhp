package com.mhp.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 量表实体类
 * 索引： idx_student_id, idx_student_no, idx_college, idx_archive_status
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PsyScale {
    // 主键
    private Long scaleId;
    // 量表名称
    private String scaleName;
    // 量表编码
    private String scaleCode;
    // 量表描述
    private String description;
    // 量表问题数量
    private Integer questionCount;
    // 量表预计时间（分钟）
    private Integer estimatedTime;
    // 适用人群
    private String targetGroup;
    // 状态：0=禁用 1=正常
    private Integer status;
    // 是否内置：0=否 1=是
    private Integer isBuiltIn;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
}
