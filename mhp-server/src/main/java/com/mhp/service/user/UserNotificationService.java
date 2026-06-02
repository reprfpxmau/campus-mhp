package com.mhp.service.user;

import com.mhp.dto.user.UserNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.result.PageResult;

public interface UserNotificationService {

    /**
     * 分页查询我的通知
     */
    PageResult pageQuery(UserNotificationPageQueryDTO dto);

    /**
     * 查询未读数量
     */
    Integer countUnread(Long userId);

    /**
     * 创建通知
     */
    void create(SysNotification notification);

    /**
     * 标记单条已读
     */
    void markRead(Long id, Long userId);

    /**
     * 标记全部已读
     */
    void markAllRead(Long userId);
}
