package com.mhp.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysCollege {
    // 学院ID
    private Integer collegeId;
    // 学院名称
    private String collegeName;
    // 创建时间
    private LocalDateTime createTime;
}
