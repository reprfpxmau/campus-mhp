package com.mhp.mapper.user;

import com.github.pagehelper.Page;
import com.mhp.dto.user.UserNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.vo.user.UserNotificationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserNotificationMapper {

    /**
     * 分页查询通知
     */
    Page<UserNotificationVO> pageQuery(UserNotificationPageQueryDTO dto);

    /**
     * 查询未读数量
     */
    @Select("SELECT COUNT(*) FROM sys_notification WHERE user_id = #{userId} AND is_read = 0")
    Integer countUnread(Long userId);

    /**
     * 插入通知
     */
    void insert(SysNotification notification);

    /**
     * 标记单条已读
     */
    @Select("UPDATE sys_notification SET is_read = 1 WHERE notification_id = #{id} AND user_id = #{userId}")
    void markRead(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 标记全部已读
     */
    @Select("UPDATE sys_notification SET is_read = 1 WHERE user_id = #{userId} AND is_read = 0")
    void markAllRead(Long userId);
}
