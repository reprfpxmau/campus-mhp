package com.mhp.mapper;

import com.mhp.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 用户角色关联表
 */

@Mapper
public interface SysUserRoleMapper {
    /**
     * 更新用户角色关联
     * @param sysUserRole
     * @return
     */
    @Update("update sys_user_role set role_id = #{roleId} where user_id = #{userId}")
    void update(SysUserRole sysUserRole);
}
