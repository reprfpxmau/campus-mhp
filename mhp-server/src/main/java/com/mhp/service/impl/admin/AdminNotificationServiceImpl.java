package com.mhp.service.impl.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.context.BaseContext;
import com.mhp.dto.admin.AdminNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.mapper.admin.AdminNotificationMapper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.AdminNotificationService;
import com.mhp.vo.admin.AdminNotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminNotificationServiceImpl implements AdminNotificationService {

    @Autowired
    private AdminNotificationMapper adminNotificationMapper;

    /**
     * 分页查询通知
     * @param dto
     * @return
     */
    @Override
    public PageResult pageQuery(AdminNotificationPageQueryDTO dto) {
        Long userId = BaseContext.getCurrentId();
        dto.setUserId(userId);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<AdminNotificationVO> page = adminNotificationMapper.pageQuery(dto);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 统计未读通知数量
     * @param userId 用户ID
     * @return 未读通知数量
     */
    @Override
    public Integer countUnread(Long userId) {
        return adminNotificationMapper.countUnread(userId);
    }

    /**
     * 创建通知
     * @param notification 通知
     */
    @Override
    public void create(SysNotification notification) {
        notification.setIsRead(0);
        notification.setCreateTime(LocalDateTime.now());
        adminNotificationMapper.insert(notification);
    }

    /**
     * 标记通知为已读
     * @param id 通知ID
     * @param userId 用户ID
     */
    @Override
    public void markRead(Long id, Long userId) {
        adminNotificationMapper.markRead(id, userId);
    }

    /**
     * 标记所有通知为已读
     * @param userId 用户ID
     */
    @Override
    public void markAllRead(Long userId) {
        adminNotificationMapper.markAllRead(userId);
    }
}
