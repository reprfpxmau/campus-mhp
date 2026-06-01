package com.mhp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.RequestPageDTO;
import com.mhp.entity.CrWarnRule;
import com.mhp.result.PageResult;
import com.mhp.mapper.WarnRuleMapper;
import com.mhp.service.WarnRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.mhp.dto.WarnRuleDTO;
import java.time.LocalDateTime;

@Service
public class WarnRuleServiceImpl implements WarnRuleService {
    @Autowired
    private WarnRuleMapper warnRuleMapper;
    /**
     * 分页查询预警规则
     * @param requestPageDTO
     * @return
     */
    @Override
    public PageResult pageQuery(RequestPageDTO requestPageDTO) {
        PageHelper.startPage(requestPageDTO.getPage(),requestPageDTO.getPageSize());
        Page<CrWarnRule> page = warnRuleMapper.pageQuery(requestPageDTO);
        Long total = page.getTotal();
        List<CrWarnRule> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 新增预警规则
     * @param warnRuleDTO
     */
    @Override
    public void add(WarnRuleDTO warnRuleDTO) {
        
        CrWarnRule crWarnRule = CrWarnRule.builder()
                .ruleName(warnRuleDTO.getRuleName())
                .dataSource(warnRuleDTO.getDataSource())
                .conditionExpr(warnRuleDTO.getConditionExpr())
                .riskLevel(warnRuleDTO.getRiskLevel())
                .notifyTargets(warnRuleDTO.getNotifyTargets())
                .build();
        crWarnRule.setCreateTime(LocalDateTime.now());
        crWarnRule.setStatus(0);
        crWarnRule.setVersion(1);
        warnRuleMapper.insert(crWarnRule);
    }

}
