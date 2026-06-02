package com.mhp.service.impl.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.mhp.result.Result;
import com.mhp.service.user.UserAuthService;
import com.mhp.constant.MessageConstant;
import com.mhp.dto.user.UserLoginDTO;
import com.mhp.entity.SysUser;
import com.mhp.mapper.user.UserMapper;
import com.mhp.utils.JwtUtil;
import com.mhp.vo.user.LoginVO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
@Slf4j
@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;
    
    /*用户登录
     * @param loginDTO 登录参数
     * @return
     */
    @Override
    public Result login(UserLoginDTO userLoginDTO) {
        String studentNo = userLoginDTO.getStudentNo();
        String password = userLoginDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        SysUser user = userMapper.login(studentNo);
        if (user == null) {
            return Result.error(MessageConstant.USERNAME_NULL);
        }
        if(!user.getPassword().equals(password)){
            return Result.error(MessageConstant.PASSWORD_ERROR);
        }
        // TODO: 校验账号禁用状态
         if (user.getStatus() == 0) { return Result.error(MessageConstant.USER_STATUS_ERROR); }

        // TODO: 根据 roleId 区分角色（admin/counselor），而非硬编码 "admin"
        String role = user.getRoleId() == 1 ? "user" : "counselor";
        String token = jwtUtil.createToken(user.getUserId(), role);

        // TODO: 返回前清除密码字段，避免泄露
        user.setPassword(null);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserInfo(user);
        log.info("用户登录成功：{}", user.getRealName());
        return Result.success(loginVO);
    }

}
