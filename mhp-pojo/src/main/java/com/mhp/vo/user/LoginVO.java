package com.mhp.vo.user;

import com.mhp.entity.SysUser;

import lombok.Data;

@Data
public class LoginVO {
    private String token;
    private SysUser userInfo;
}
