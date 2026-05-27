package com.mhp.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * 用户档案实体类
 * INDEX: idx_student_id, idx_scale_id, idx_status
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PsyExamRecord implements Serializable{
    // 记录ID
    private Long recordId;
    // 学生ID
    private Long studentId;
    // 量表ID
    private Long scaleId;
    // 开始时间
    private LocalDateTime startTime;
    // 提交时间
    private LocalDateTime submitTime;
    // 答题时长(秒)
    private Integer duration;
    //状态：0=未完成 1=已完成
    private Integer status;
    //是否有效
    private Integer isValid;
    // 创建时间
    private LocalDateTime createTime;
    
}