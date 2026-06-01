package com.mhp.dto.user;

import lombok.Data;

@Data
public class UserLoginDTO {
    // 学号
    private String studentNo;
    // 密码
    private String password;
}
