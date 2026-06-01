package com.mhp.vo.admin;

import lombok.Data;


@Data
public class WarnPageQueryVO {

    // 预警事件字段
    private Long eventId;
    private Long studentId; 
    private Long assessmentId;
    private Integer eventLevel;
    private Integer eventStatus;
    private String triggerSource;
    private String createTime;

    //学号
    private String studentNo;
    // 学生姓名
    private String studentName;

}
