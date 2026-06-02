package com.mhp.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 通知实体类
 */
@Data
public class SysNotification {
    private Long notificationId;
    private Long userId;
    private String type;
    private String title;
    private String content;
    private String relatedType;
    private Long relatedId;
    private Integer isRead;
    private LocalDateTime createTime;
}
