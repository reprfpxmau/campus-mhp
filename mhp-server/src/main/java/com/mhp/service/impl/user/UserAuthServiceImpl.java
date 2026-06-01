package com.mhp.service.impl.user;

import com.mhp.dto.user.UserLoginDTO;
import com.mhp.result.Result;
import org.springframework.stereotype.Service;
import com.mhp.service.user.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    
    @Override
    public Result login(UserLoginDTO userLoginDTO) {
        return Result.success();
    }
}
