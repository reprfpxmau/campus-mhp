package com.mhp.vo;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class AppointmentPageQueryVO {
    // 测评记录字段
    private Long appointmentId;
    private Long studentId;
    private Long counselorId;
    private String appointmentDate;
    private String startTime;
    private String endTime;
    private Integer status;
    private String reason;
  
    // 学生姓名
    private String studentName;
    // 咨询师姓名
    private String counselorName;

}
