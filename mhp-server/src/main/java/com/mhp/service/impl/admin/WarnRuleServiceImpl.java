package com.mhp.service.impl.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.entity.CrWarnRule;
import com.mhp.mapper.admin.WarnRuleMapper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.WarnRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.dto.admin.WarnRuleDTO;
import com.mhp.constant.MessageConstant;
import com.mhp.exception.BusinessException;

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

    /**
     * 更新预警规则
     * @param warnRuleDTO
     */
    @Override
    public void update(WarnRuleDTO warnRuleDTO) {
        Integer status = warnRuleMapper.selectStatus(warnRuleDTO.getRuleId());
        if(status == 1) {
            throw new RuntimeException(MessageConstant.WARN_RULE_ENABLED);
        }
        CrWarnRule crWarnRule = CrWarnRule.builder()
                .ruleId(warnRuleDTO.getRuleId())
                .ruleName(warnRuleDTO.getRuleName())
                .dataSource(warnRuleDTO.getDataSource())
                .conditionExpr(warnRuleDTO.getConditionExpr())
                .riskLevel(warnRuleDTO.getRiskLevel())
                .notifyTargets(warnRuleDTO.getNotifyTargets())
                .build();
        Integer version = warnRuleMapper.selectVersion(warnRuleDTO.getRuleId());
        crWarnRule.setVersion(version + 1);
        warnRuleMapper.update(crWarnRule);
    }

    /**
     * 更新预警规则状态
     * @param ruleId
     * @param status
     */
    @Override
    public void updateStatus(Integer status, Long ruleId) {
        CrWarnRule crWarnRule = CrWarnRule.builder()
                .ruleId(ruleId)
                .status(status)
                .build();
        warnRuleMapper.update(crWarnRule);
    }

    /**
     * 删除预警规则
     * @param id
     */
    @Override
    public void deleteBatch(List<Long> ids) {
        //判断是否存在启用的预警规则
        Integer count = warnRuleMapper.selectCountByRuleIds(ids);
        if(count > 0) {
            throw new BusinessException(MessageConstant.WARN_RULE_ENABLED_DELETE);
        }
        warnRuleMapper.deleteBatch(ids);
    }
}
