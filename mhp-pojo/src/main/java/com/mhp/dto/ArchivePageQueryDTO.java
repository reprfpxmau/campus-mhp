package com.mhp.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ArchivePageQueryDTO implements Serializable {
    
    private Integer page;
    private Integer pageSize;

    // 姓名
    private String name;
    // 学号
    private String studentNo;
    // 学院ID
    private Long collegeId;
    // 档案状态
    private String archiveStatus;
}
