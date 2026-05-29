package com.mhp.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.entity.SysUser;
import com.mhp.result.PageResult;
import com.mhp.service.UserService;
import com.mhp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPage(),userPageQueryDTO.getPageSize());
        Page<SysUser> page = userMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<SysUser> records = page.getResult();
        return new PageResult(total, records);
    }
}
