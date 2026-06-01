package com.mhp.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MhArchiveVO {
         // 主键
    private Long archiveId;
    // 学生ID
    private Long studentId;
    // 学号
    private String studentNo;
    // 姓名
    private String name;
    // 性别
    private Integer gender;
    // 学院ID
    private Long collegeId;
    // 班级ID
    private Long classId;
    // 出生日期
    private LocalDate birthDate;
    // 家庭结构
    private String familyStructure;
    // 既往病史
    private String medicalHistory;
    // 成长重大事件
    private String majorEvents;
    // 档案状态：1=正常 2=重点关注 3=高危 4=已归档
    private Integer archiveStatus;
    // 风险等级：0=正常 1=预警 2=高危
    private Integer riskLevel;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
    
    // 学院名称
    private String collegeName;
    // 班级名称
    private String className;
}
