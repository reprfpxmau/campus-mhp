package com.mhp.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 咨询会话实体类
 * INDEX: idx_student_id, idx_counselor_id
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsConsultSession {
    // 主键
    private Long sessionId;
    // 预约ID
    private Long appointmentId;
    // 咨询学生ID
    private Long studentId;
    // 咨询师ID
    private Long counselorId;
    // 会话类型:1=文字 2=语音 3=视频
    private Integer sessionType;
    // 开始时间
    private LocalDateTime startTime;
    // 结束时间
    private LocalDateTime endTime;
    // 时长
    private Integer duration;
    // 状态:0=进行中 1=已结束
    private Integer status;
}
