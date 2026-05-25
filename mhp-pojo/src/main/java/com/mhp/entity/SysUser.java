package com.mhp.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private Long userId;
    private String studentNo; 
    private String realName;
    private String idCard;
    private String password;
    private String phone;
    private Integer status;
    private Long roleId;
    private String createTime;
    private String updateTime;

}
