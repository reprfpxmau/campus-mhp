package com.mhp.mapper;

import com.mhp.vo.WarnPageQueryVO;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.entity.CrRiskAssessment;
import org.apache.ibatis.annotations.Select;
import com.mhp.entity.CrWarnProcess;

@Mapper
public interface WarnMapper {
    /**
     * 分页查询预警事件
     * @param warnPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<WarnPageQueryVO> pageQuery(WarnPageQueryDTO warnPageQueryDTO);
    /**
     * 预警评估详情
     * @param assessmentId 预警评估ID
     * @return 预警评估详情对象
     */
    @Select("select * from cr_risk_assessment where assessment_id = #{assessmentId}")
    CrRiskAssessment getDetail(Long assessmentId);
    
    /**
     * 预警处理
     * @param crWarnProcess 预警处理对象
     * @return
     */
    void insert(CrWarnProcess crWarnProcess);
    
}
