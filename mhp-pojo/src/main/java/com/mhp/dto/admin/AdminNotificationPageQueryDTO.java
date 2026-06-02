package com.mhp.dto.admin;

import lombok.Data;

/**
 * 通知分页查询DTO
 */
@Data
public class AdminNotificationPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Long userId;
    private String type;
    private Integer isRead;
}
