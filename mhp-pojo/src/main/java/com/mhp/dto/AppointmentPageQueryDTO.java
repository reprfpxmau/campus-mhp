package com.mhp.dto;

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
}
