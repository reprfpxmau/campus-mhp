package com.mhp.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 预约实体类
 * INDEX: idx_student_id, idx_counselor_id, idx_status, idx_appointment_date
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsAppointment {
    // 主键
    private Long appointmentId;
    // 学生ID
    private Long studentId;
    // 咨询师ID
    private Long counselorId;
    // 预约日期
    private LocalDate appointmentDate;
    // 开始时间
    private LocalTime startTime;
    // 结束时间
    private LocalTime endTime;
    // 预约状态：0=待确认 1=已确认 2=已拒绝 3=已取消 4=已完成
    private Integer status;
    // 预约事由
    private String reason;
    // 创建时间
    private LocalDateTime createTime;
    // 确认时间
    private LocalDateTime confirmTime;
}
