package com.mhp.service.impl.user;

import com.mhp.entity.PsyScale;
import org.springframework.stereotype.Service;
import com.mhp.mapper.user.UserScaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.Result;
import com.mhp.service.user.UserScaleService;
import java.util.List;

@Service
public class UserScaleServiceImpl implements UserScaleService {
    @Autowired
    private UserScaleMapper userScaleMapper;
    
    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    @Override
    public Result<List<PsyScale>> scaleList() {
    List<PsyScale> psyScale = userScaleMapper.scaleList();
        return Result.success(psyScale);
    }
}
