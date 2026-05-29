package com.mhp.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserPageQueryVO {
    // 用户表字段
    private Long userId;
    private String studentNo; 
    private String realName;
    private String phone;
    private Integer status;
    private LocalDateTime createTime;

    // 角色表字段
    private String roleName;

}
