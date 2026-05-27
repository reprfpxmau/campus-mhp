package com.mhp.vo;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class ExamPageQueryVO {
     // 测评记录字段
    private Long recordId;
    private Long studentId;
    private Long scaleId;
    private String startTime;
    private String submitTime;
    private Integer duration;
    private Integer status;
    private Integer isValid;
    private LocalDateTime createTime;
    
    //学号
    private String studentNo;
    // 学生姓名
    private String studentName;
    // 量表名称
    private String scaleName;

}
