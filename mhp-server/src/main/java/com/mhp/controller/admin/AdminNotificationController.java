package com.mhp.controller.admin;

import com.mhp.context.BaseContext;
import com.mhp.dto.admin.AdminNotificationPageQueryDTO;
import com.mhp.entity.SysNotification;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.admin.AdminNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/notification")
@Tag(name = "管理员端-通知接口")
@Slf4j
public class AdminNotificationController {

    @Autowired
    private AdminNotificationService adminNotificationService;

    /**
     * 分页查询我的通知
     */
    @GetMapping("/list")
    @Operation(summary = "分页查询我的通知")
    public Result<PageResult> list(AdminNotificationPageQueryDTO dto) {
        PageResult result = adminNotificationService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 查询未读数量
     */
    @GetMapping("/unread-count")
    @Operation(summary = "查询未读通知数量")
    public Result<Integer> unreadCount() {
        Long userId = BaseContext.getCurrentId();
        Integer count = adminNotificationService.countUnread(userId);
        return Result.success(count);
    }

    /**
     * 标记单条已读
     */
    @PostMapping("/read/{id}")
    @Operation(summary = "标记单条通知已读")
    public Result markRead(@PathVariable Long id) {
        Long userId = BaseContext.getCurrentId();
        adminNotificationService.markRead(id, userId);
        return Result.success();
    }

    /**
     * 标记全部已读
     */
    @PostMapping("/read-all")
    @Operation(summary = "标记全部通知已读")
    public Result markAllRead() {
        Long userId = BaseContext.getCurrentId();
        adminNotificationService.markAllRead(userId);
        return Result.success();
    }
}
