package com.mhp.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.admin.RequestPageDTO;
import com.mhp.entity.CrWarnRule;

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
}
