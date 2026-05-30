package com.mhp.entity;


import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * 角色实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRole{
    // 角色ID
    private Long roleId;
    // 角色编码ADMIN/COUNSELOR/STUDENT（管理员/咨询师/咨询学生）
    private String roleCode;
    // 角色名称
    private String roleName;
    // 数据范围：1=全部 2=本学院 3=个人
    private Integer dataScope;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
}