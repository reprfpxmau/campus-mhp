package com.mhp.entity;


import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 用户角色关联实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole implements Serializable {
    // 用户ID
    private Long userId;
    // 角色ID
    private Long roleId;
}