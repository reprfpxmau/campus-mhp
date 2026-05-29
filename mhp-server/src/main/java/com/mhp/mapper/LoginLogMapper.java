package com.mhp.mapper;

import com.mhp.dto.AdminLoginLogDTO;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.SysLoginLog;

@Mapper
public interface LoginLogMapper {
    /**
     * 分页查询登录日志
     * @param adminLoginLogDTO
     * @return
     */
    Page<SysLoginLog> pageQuery(AdminLoginLogDTO adminLoginLogDTO);
}
