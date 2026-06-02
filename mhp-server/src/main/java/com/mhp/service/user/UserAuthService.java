package com.mhp.service.user;

import org.springframework.stereotype.Service;
import com.mhp.dto.user.UserLoginDTO;
import com.mhp.result.Result;
import com.mhp.vo.admin.LoginVO;

@Service
public interface UserAuthService {
     /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    Result<LoginVO> login(UserLoginDTO userLoginDTO);
}
