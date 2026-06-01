package com.mhp.vo.admin;

import lombok.Data;

/**
 * 用户详情VO
 */
@Data
public class UserVO {
    //用户表字段
    private Long userId;
    private String studentNo;
    private String realName;
    private String phone;
    private String idCard;
    private String avatar;
    private Integer status;
    private String createTime;
    private String updateTime;

    //用户角色关联表字段
    private Long roleId;
    private String roleName;
}
