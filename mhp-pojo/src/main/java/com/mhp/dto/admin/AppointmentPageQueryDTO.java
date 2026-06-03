package com.mhp.dto.admin;

import lombok.Data;

@Data
public class AppointmentPageQueryDTO {
    private Integer page;
    private Integer pageSize;

    // 学生姓名
    private String studentName;
    // 学生ID（用户端查询自己的预约）
    private Long studentId;
    // 状态
    private Integer status;
    // 预约日期
    private String appointmentDate;
    // 咨询师ID（用于角色过滤）
    private Long counselorId;
}
