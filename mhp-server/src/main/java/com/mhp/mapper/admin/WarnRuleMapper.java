package com.mhp.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.entity.CrWarnRule;
import java.util.List;

import org.apache.ibatis.annotations.Select;

@Mapper
public interface WarnRuleMapper {
    /**
     * 分页查询预警规则
     * @param requestPageDTO
     * @return
     */
    @Select("select * from cr_warn_rule")
    Page<CrWarnRule> pageQuery(RequestPageDTO requestPageDTO);

    /**
     * 新增预警规则
     * @param crWarnRule
     */
    void insert(CrWarnRule crWarnRule);

    /**
     * 更新预警规则
     * @param crWarnRule
     */
    void update(CrWarnRule crWarnRule);

    /**
     * 查询预警规则状态
     * @param ruleId
     * @return
     */
    @Select("select status from cr_warn_rule where rule_id = #{ruleId}")
    Integer selectStatus(Long ruleId);

    /**
     * 查询预警规则版本
     * @param ruleId
     * @return
     */
    @Select("select version from cr_warn_rule where rule_id = #{ruleId}")
    Integer selectVersion(Long ruleId);

    /**
     * 删除预警规则
     * @param id
     */
    void deleteBatch(List<Long> ids);

    /**
     * 查询启用的预警规则数量
     * @param ruleIds
     * @return
     */
    Integer selectCountByRuleIds(List<Long> ruleIds);

}