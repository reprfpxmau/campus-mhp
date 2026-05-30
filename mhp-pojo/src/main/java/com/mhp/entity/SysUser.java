package com.mhp.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 用户实体类
 * 索引： idx_role_id, idx_student_no
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser{
    // 主键
    private Long userId;
    // 学号/工号
    private String studentNo; 
    // 姓名
    private String realName;
    // 身份证号
    private String idCard;
    // 密码
    private String password;
    // 手机号
    private String phone;
    // 状态：0=禁用 1=正常
    private Integer status;
    // 角色ID
    private Long roleId;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;

}
