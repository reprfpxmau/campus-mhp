package com.mhp.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    // 主键ID
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
    // 状态（0：禁用，1：正常，2：锁定，3：删除）
    private Integer status;
    // 角色ID
    private Long roleId;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
}