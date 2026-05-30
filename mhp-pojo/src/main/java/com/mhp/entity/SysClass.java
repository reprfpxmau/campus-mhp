package com.mhp.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysClass {
    // 班级ID
    private Long classId;
    // 班级名称
       private String className;
    // 学院ID
    private Integer collegeId;
    // 创建时间
    private LocalDateTime createTime;
    
}
