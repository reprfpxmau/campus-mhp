package com.mhp.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 咨询师排班实体类
 * INDEX: idx_counselor_date (counselor_id, work_date)
 */
@Data
public class CsSchedule {
    // 主键
    private Long scheduleId;
    // 咨询师ID
    private Long counselorId;
    // 工作日期
    private LocalDate workDate;
    // 开始时间
    private LocalTime startTime;
    // 结束时间
    private LocalTime endTime;
    // 是否可预约:0=否 1=是
    private Integer isAvailable;
}
