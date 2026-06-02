package com.mhp.service.user;

import com.mhp.entity.PsyScale;
import org.springframework.stereotype.Service;
import com.mhp.result.Result;
import java.util.List;

@Service
public interface UserScaleService {

    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    Result<List<PsyScale>> scaleList();
}
