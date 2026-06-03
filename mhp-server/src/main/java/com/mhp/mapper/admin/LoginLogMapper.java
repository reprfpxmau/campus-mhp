package com.mhp.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.admin.AdminLoginLogDTO;
import com.mhp.vo.admin.LoginLogVO;

@Mapper
public interface LoginLogMapper {
    /**
     * 分页查询登录日志
     * @param adminLoginLogDTO
     * @return
     */
    Page<LoginLogVO> pageQuery(AdminLoginLogDTO adminLoginLogDTO);
}
