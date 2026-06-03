package com.mhp.vo.admin;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArchiveVersionVO {
    private Long versionId;
    private Long archiveId;
    private Long operatorId;
    private String operatorName;
    private String operationType;
    private String changedFields;
    private String snapshot;
    private LocalDateTime versionTime;
}
