package com.mhp.dto.admin;

import lombok.Data;

@Data
public class OperationLogPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Long archiveId;
    private Long operatorId;
}
