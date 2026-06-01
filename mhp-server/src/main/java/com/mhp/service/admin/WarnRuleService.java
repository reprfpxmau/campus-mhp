package com.mhp.service.admin;

import com.mhp.result.PageResult;
import org.springframework.stereotype.Service;

import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.dto.admin.WarnRuleDTO;


@Service
public interface WarnRuleService {
    /**
     * 分页查询预警规则
     * @param requestPageDTO
     * @return
     */
    PageResult pageQuery(RequestPageDTO requestPageDTO);

    /**
     * 新增预警规则
     * @param warnRuleDTO
     */
    void add(WarnRuleDTO warnRuleDTO);
}
