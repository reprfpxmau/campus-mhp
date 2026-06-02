package com.mhp.dto.user;

import lombok.Data;

/**
 * 通知分页查询DTO
 */
@Data
public class UserNotificationPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Long userId;
    private String type;
    private Integer isRead;
}
