package com.mhp.vo;

import com.mhp.entity.SysUser;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    // 登录凭证（JWT）
    private String token;
    // 用户信息
    private SysUser userInfo;
}
