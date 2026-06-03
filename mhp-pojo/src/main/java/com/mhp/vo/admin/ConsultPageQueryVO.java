package com.mhp.vo.admin;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConsultPageQueryVO {
     // 主键
    private Long recordId;
    // 会话ID
    private Long sessionId;
    // 咨询师ID
    private Long counselorId;
    // 咨询学生ID
    private Long studentId;
    // 主诉(加密)
    private String chiefComplaint;
    // 咨询过程(加密)
    private String consultProcess;
    // 评估(加密)
    private String assessment;
    // 建议(加密)
    private String suggestion;
    // 归档状态:0=待归档 1=已归档
    private Integer archiveStatus;
    // 创建时间
    private LocalDateTime createTime;

    
    private String studentName;
    private String counselorName;
}
