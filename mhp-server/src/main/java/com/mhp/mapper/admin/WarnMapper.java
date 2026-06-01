package com.mhp.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.admin.WarnPageQueryDTO;
import com.mhp.entity.CrRiskAssessment;
import org.apache.ibatis.annotations.Select;
import com.mhp.entity.CrWarnProcess;
import com.mhp.vo.admin.WarnPageQueryVO;
import com.mhp.entity.CrWarnEvent;
import java.util.List;

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
    
    /**
     * 更新预警事件状态
     * @param crWarnEvent 预警事件对象
     * @return
     */
    void processUpdate(CrWarnEvent crWarnEvent);

    /**
     * 分发预警事件
     * @param crWarnEvent 预警事件对象
     * @return
     */
    void distributeUpdate(CrWarnEvent crWarnEvent);

    /**
     * 根据事件ID查询预警处理记录
     * @param eventId 预警事件ID
     * @return 预警处理记录列表
     */
    List<CrWarnProcess> selectProcessByEventId(Long eventId);

    /**
     * 关闭所有未处理的预警处理记录
     * @param eventId 预警事件ID
     * @return
     */
    void closeOpenProcesses(Long eventId);

    
}
