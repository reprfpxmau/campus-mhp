package com.mhp.entity;


import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 角色实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRole implements Serializable {
    // 角色ID
    private Long roleId;
    // 角色编码
    private String roleCode;
    // 角色名称
    private String roleName;
    // 数据范围：1=全部 2=本学院 3=个人
    private String dataScope;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
}