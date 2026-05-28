package com.mhp.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 预警处理实体类
 * INDEX: idx_event_id
 */
@Data
public class CrWarnProcess {
    // 主键
    private Long processId;
    // 事件ID
    private Long eventId;
    // 处理人ID
    private Long handlerId;
    // 处理方式(电话访谈/面谈/转介)
    private String processType;
    // 处理内容
    private String processContent;
    // 处理结果
    private String processResult;
    // 后续跟踪计划
    private String followUpPlan;
    // 处理时间
    private LocalDateTime processTime;
    // 处理状态：0=待处理 1=已完成
    private Integer status;
}
