package com.mhp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mhp.result.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import com.mhp.constant.MessageConstant;
import com.mhp.dto.AdminLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.service.AdminService;
import com.mhp.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.mapper.AdminMapper;
import com.mhp.vo.LoginVO;
import org.springframework.util.DigestUtils;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @Override
    public Result<LoginVO> login(AdminLoginDTO adminLoginDTO) {
        String studentNo = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        SysUser admin = adminMapper.login(studentNo);
        if (admin == null) {
            return Result.error(MessageConstant.USERNAME_NULL);
        }
        if(!admin.getPassword().equals(password)){
            return Result.error(MessageConstant.PASSWORD_ERROR);
        }
        // TODO: 校验账号禁用状态
        // if (admin.getStatus() == 0) { return Result.error("账号已被禁用"); }

        // TODO: 根据 roleId 区分角色（admin/counselor），而非硬编码 "admin"
        // String role = admin.getRoleId() == 1 ? "admin" : "counselor";
        String token = jwtUtil.createToken(admin.getUserId(), "admin");

        // TODO: 返回前清除密码字段，避免泄露
        // admin.setPassword(null);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserInfo(admin);
        log.info("管理员登录成功：{}", admin.getRealName());
        return Result.success(loginVO);
    }

    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPage(),userPageQueryDTO.getPageSize());
        Page<SysUser> page = adminMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<SysUser> records = page.getResult();
        return new PageResult(total, records);
    }
}
