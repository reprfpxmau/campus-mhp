package com.mhp.service.admin;

import com.mhp.result.PageResult;
import org.springframework.stereotype.Service;

import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.dto.admin.WarnRuleDTO;
import java.util.List;


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

    /**
     * 更新预警规则
     * @param warnRuleDTO
     */
    void update(WarnRuleDTO warnRuleDTO);

    /**
     * 更新预警规则状态
     * @param id
     * @param status
     */
    void updateStatus(Integer status, Long id);

    /**
     * 删除预警规则
     * @param id
     */
    void deleteBatch(List<Long> ids);
}
