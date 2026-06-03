package com.mhp.service.user;

import com.mhp.entity.PsyScale;
import org.springframework.stereotype.Service;
import com.mhp.result.Result;
import java.util.List;
import com.mhp.vo.user.ScaleVO;

@Service
public interface UserScaleService {

    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    Result<List<PsyScale>> scaleList();

    /**
     * 查询用户测试题目
     * @param scaleId 测试项ID
     * @return 测试题目
     */
    ScaleVO scale(Integer scaleId);
}
