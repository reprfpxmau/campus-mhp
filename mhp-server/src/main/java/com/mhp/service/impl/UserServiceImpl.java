package com.mhp.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.entity.SysUser;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import com.mhp.service.UserService;
import com.mhp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.mhp.vo.UserPageQueryVO;
import com.mhp.mapper.SysUserRoleMapper;
import com.mhp.entity.SysUserRole;
import com.mhp.vo.UserVO;
import com.mhp.constant.MessageConstant;
import com.mhp.exception.BusinessException;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
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
    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @Override
    public void update(SysUser sysUser) {

        //默认更新时间为当前时间
        sysUser.setUpdateTime(LocalDateTime.now());
        userMapper.update(sysUser);
        //更新用户角色关联
        SysUserRole sysUserRole = SysUserRole.builder()
                .userId(sysUser.getUserId())
                .roleId(sysUser.getRoleId())
                .build();
        sysUserRoleMapper.update(sysUserRole);
    }

    /**
     * 启用/禁用用户
     * @param status
     * @param userId
     * @return
     */
    @Override
    public void updateStatus(Integer status,Long userId) {
        if(userId.equals(1L)) {
            throw new BusinessException(MessageConstant.ADMIN_ACCOUNT_CANNOT_BE_ENABLED_OR_DISABLED);
        }
        SysUser sysUser = SysUser.builder()
                .userId(userId)
                .status(status)
                .build();
        userMapper.update(sysUser);
    }
    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    @Override
    public UserVO getDetail(Long userId) {
        UserVO userVO = new UserVO();
        userVO = userMapper.selectByUserId(userId);
        return userVO;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Override
    public void deleteBatch(List<Long> ids) {
        if(ids.contains(1L)) {
            throw new BusinessException(MessageConstant.ADMIN_ACCOUNT_CANNOT_BE_DELETED);
        }
        Long count = userMapper.countByIds(ids);
        if(count > 0) {
            throw new BusinessException(MessageConstant.ENABLED_USER_CANNOT_BE_DELETED);
        }
        userMapper.deleteBatch(ids);
    }
}
