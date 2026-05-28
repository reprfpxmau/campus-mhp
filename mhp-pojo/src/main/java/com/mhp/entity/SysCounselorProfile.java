package com.mhp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 咨询师扩展实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysCounselorProfile implements Serializable {
    // 主键
    private Long counselorId;
    // 用户ID
    private Long userId;
    // 资质证书
    private String certificate;
    // 擅长领域
    private String specialty;
    // 工作经历
    private String workExperience;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
}
