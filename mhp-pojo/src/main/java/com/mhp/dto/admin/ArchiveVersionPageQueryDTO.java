package com.mhp.dto.admin;

import lombok.Data;

@Data
public class ArchiveVersionPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Long archiveId;
}
