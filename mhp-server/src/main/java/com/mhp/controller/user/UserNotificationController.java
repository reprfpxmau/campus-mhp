package com.mhp.controller.user;

import com.mhp.context.BaseContext;
import com.mhp.dto.user.UserNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.user.UserNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/notification")
@Tag(name = "用户端-通知接口")
@Slf4j
public class UserNotificationController {

    @Autowired
    private UserNotificationService notificationService;

    /**
     * 分页查询我的通知
     */
    @GetMapping("/list")
    @Operation(summary = "分页查询我的通知")
    public Result<PageResult> list(UserNotificationPageQueryDTO dto) {
        PageResult result = notificationService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 查询未读数量
     */
    @GetMapping("/unread-count")
    @Operation(summary = "查询未读通知数量")
    public Result<Integer> unreadCount() {
        Long userId = BaseContext.getCurrentId();
        Integer count = notificationService.countUnread(userId);
        return Result.success(count);
    }

    /**
     * 标记单条已读
     */
    @PostMapping("/read/{id}")
    @Operation(summary = "标记单条通知已读")
    public Result markRead(@PathVariable Long id) {
        Long userId = BaseContext.getCurrentId();
        notificationService.markRead(id, userId);
        return Result.success();
    }

    /**
     * 标记全部已读
     */
    @PostMapping("/read-all")
    @Operation(summary = "标记全部通知已读")
    public Result markAllRead() {
        Long userId = BaseContext.getCurrentId();
        notificationService.markAllRead(userId);
        return Result.success();
    }
}
