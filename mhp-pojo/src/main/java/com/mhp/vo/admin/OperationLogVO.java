package com.mhp.vo.admin;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OperationLogVO {
    private Long logId;
    private Long archiveId;
    private Long operatorId;
    private String operatorName;
    private String operation;
    private LocalDateTime operationTime;
    private String ipAddress;
}
