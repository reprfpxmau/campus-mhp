package com.mhp.service.user;

import org.springframework.stereotype.Service;  
import com.mhp.dto.user.UserLoginDTO;
import com.mhp.result.Result;

@Service
public interface UserAuthService {
    /**
     * 学生登录
     * @param userLoginDTO
     * @return
     */
    Result login(UserLoginDTO userLoginDTO);
}
