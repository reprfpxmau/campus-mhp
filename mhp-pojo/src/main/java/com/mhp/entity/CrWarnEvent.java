package com.mhp.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * 预警事件实体类
 * INDEX: idx_student_id, idx_event_status
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrWarnEvent {
    // 主键
    private Long eventId;
    // 学生ID
    private Integer studentId;
    // 评估ID
    private Long assessmentId;
    // 事件级别：1=低 2=中 3=高
    private Integer eventLevel;
    // 事件状态：0=待分发 1=待处理 2=处理中 3=已处理
    private Integer eventStatus;
    // 触发来源（如EXAM）
    private String triggerSource;
    // 处理人ID
    private Integer handlerId;
    // 创建时间
    private LocalDateTime createTime;
}
