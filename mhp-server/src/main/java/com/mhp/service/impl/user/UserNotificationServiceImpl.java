package com.mhp.service.impl.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.context.BaseContext;
import com.mhp.dto.user.UserNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.mapper.user.UserNotificationMapper;
import com.mhp.result.PageResult;
import com.mhp.service.user.UserNotificationService;
import com.mhp.vo.user.UserNotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private UserNotificationMapper notificationMapper;

    /**
     * 分页查询通知
     * @param dto
     * @return
     */
    @Override
    public PageResult pageQuery(UserNotificationPageQueryDTO dto) {
        Long userId = BaseContext.getCurrentId();
        dto.setUserId(userId);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<UserNotificationVO> page = notificationMapper.pageQuery(dto);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 统计未读通知数量
     * @param userId 用户ID
     * @return 未读通知数量
     */
    @Override
    public Integer countUnread(Long userId) {
        return notificationMapper.countUnread(userId);
    }

    /**
     * 创建通知
     * @param notification 通知
     */
    @Override
    public void create(SysNotification notification) {
        notification.setIsRead(0);
        notification.setCreateTime(LocalDateTime.now());
        notificationMapper.insert(notification);
    }

    /**
     * 标记通知为已读
     * @param id 通知ID
     * @param userId 用户ID
     */
    @Override
    public void markRead(Long id, Long userId) {
        notificationMapper.markRead(id, userId);
    }

    /**
     * 标记所有通知为已读
     * @param userId 用户ID
     */
    @Override
    public void markAllRead(Long userId) {
        notificationMapper.markAllRead(userId);
    }
}
