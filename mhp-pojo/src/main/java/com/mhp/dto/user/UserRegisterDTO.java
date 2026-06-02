package com.mhp.dto.user;

import lombok.Data;

@Data
public class UserRegisterDTO {
   private String studentNo;
   private String password;
   private String realName;
   private String phone;
   private Integer gender;
   private String idCard;
}
