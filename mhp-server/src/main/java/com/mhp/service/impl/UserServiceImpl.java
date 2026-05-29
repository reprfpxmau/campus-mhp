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
import java.time.LocalDateTime;
import com.mhp.vo.UserPageQueryVO;



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
        Page<UserPageQueryVO> page = userMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<UserPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @Override
    public void add(SysUser sysUser) {
        //默认状态为0
        sysUser.setStatus(0);
        //默认创建时间为当前时间
        sysUser.setCreateTime(LocalDateTime.now());
        userMapper.insert(sysUser);
    }
}
