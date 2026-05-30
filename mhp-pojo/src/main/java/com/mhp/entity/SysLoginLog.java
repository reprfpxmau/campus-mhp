package com.mhp.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 登录日志实体类
 * 索引： idx_user_id, idx_login_time
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginLog{
    // 主键
    private Long logId;
    // 用户ID
    private Long userId;
    // 登录方式：1=密码 2=短信
    private Integer loginType;
    // IP地址
    private String ipAddress;
    // 浏览器标识
    private String userAgent;
    // 登录状态：0=失败 1=成功
    private Integer loginStatus;
    // 登录时间
    private LocalDateTime loginTime;
}
