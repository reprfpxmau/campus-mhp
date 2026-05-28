package com.mhp.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 操作日志实体类
 * INDEX: idx_archive_id
 */
@Data
public class MhOperationLog {
    // 主键
    private Long logId;
    // 档案ID
    private Long archiveId;
    // 操作人ID
    private Long operatorId;
    // 操作内容
    private String operation;
    // 操作时间
    private LocalDateTime operationTime;
    // 操作IP
    private String ipAddress;
}
