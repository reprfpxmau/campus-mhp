package com.mhp.dto;

import lombok.Data;

@Data
public class CrWarnProcessDTO {
    // 预警事件ID
    private Long eventId;
    // 处理人ID
    private Long handlerId;
    // 预警处理类型
    private String processType;
    // 预警处理内容
    private String processContent;
    // 预警处理结果
    private String processResult;
    // 预警处理后续计划
    private String followUpPlan;
}
