package com.mhp.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 用户个人信息实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserProfile{
    // 主键
    private Long profileId;
    // 用户ID
    private Long userId;
    // 头像
    private String avatar;
    // 紧急联系人
    private String emergencyContact;
    // 紧急联系人手机号
    private String emergencyPhone;
    // 个人简介
    private String bio;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
    // 隐私级别：1=公开 2=仅自己可见
    private Integer privacyLevel;
}
