package com.mhp.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 档案版本实体类
 * INDEX: idx_archive_id
 */
@Data
public class MhArchiveVersion {
    // 主键
    private Long versionId;
    // 档案ID
    private Long archiveId;
    // 操作人ID
    private Long operatorId;
    // 操作类型
    private String operationType;
    // 变更字段
    private String changedFields;
    // 数据快照
    private String snapshot;
    // 版本时间
    private LocalDateTime versionTime;
}
