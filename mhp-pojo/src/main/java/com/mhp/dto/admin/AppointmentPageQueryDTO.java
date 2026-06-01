package com.mhp.dto.admin;

import java.io.Serializable;
import lombok.Data;

@Data
public class AppointmentPageQueryDTO implements Serializable {
    private Integer page;
    private Integer pageSize;

    // 学生姓名
    private String studentName;
    // 状态
    private Integer status;
    // 预约日期
    private String appointmentDate;
    // 咨询师ID（用于角色过滤）
    private Long counselorId;
}
