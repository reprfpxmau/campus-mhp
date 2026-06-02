package com.mhp.vo.admin;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 通知分页查询VO
 */
@Data
public class AdminNotificationVO {
    private Long notificationId;
    private String type;
    private String title;
    private String content;
    private String relatedType;
    private Long relatedId;
    private Integer isRead;
    private LocalDateTime createTime;
}
