package com.mhp.dto.admin;

import lombok.Data;

@Data
public class ConsultDTO {
    private Integer page;
    private Integer pageSize;
    private Long counselorId;
    private Long studentId;
    private String studentName;
    private Integer archiveStatus;
}
