package com.mhp.service;

import com.mhp.dto.RequestPageDTO;
import com.mhp.result.PageResult;
import org.springframework.stereotype.Service;


@Service
public interface WarnRuleService {
    /**
     * 分页查询预警规则
     * @param requestPageDTO
     * @return
     */
    PageResult pageQuery(RequestPageDTO requestPageDTO);
}
