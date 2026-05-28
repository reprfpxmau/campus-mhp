package com.mhp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.AdminLoginLogDTO;
import com.mhp.result.PageResult;
import com.mhp.mapper.LoginLogMapper;
import com.mhp.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.mhp.entity.SysLoginLog;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public PageResult pageQuery(AdminLoginLogDTO adminLoginLogDTO) {
        PageHelper.startPage(adminLoginLogDTO.getPage(),adminLoginLogDTO.getPageSize());
        Page<SysLoginLog> page = loginLogMapper.pageQuery(adminLoginLogDTO);
        Long total = page.getTotal();
        List<SysLoginLog> records = page.getResult();
        return new PageResult(total,records);
    }
}
