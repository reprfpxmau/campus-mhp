package com.mhp.dto;

import lombok.Data;

@Data
public class ExamPageQueryDTO {
    private Integer page;
    private Integer pageSize;

    // 学号
    private String studentNo;
    // 量表名称
    private String scaleName;
    // 测评状态:0进行中 1已提交 2暂存
    private String status;
}
