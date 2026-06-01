package com.mhp.service;
import org.springframework.stereotype.Service;
import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.dto.CrWarnProcessDTO;    
import com.mhp.dto.DistributeDTO;
import com.mhp.entity.CrRiskAssessment;
import com.mhp.entity.CrWarnProcess;
import java.util.List;

@Service
public interface WarnService {
    /**
     * 分页查询预警
     * @param warnPageQueryDTO
     * @return
     */
    
    PageResult pageQuery(WarnPageQueryDTO warnPageQueryDTO);
    /**
     * 预警评估详情
     * @param assessmentId
     * @return
     */
    CrRiskAssessment getDetail(Long assessmentId);

    /**
     * 预警处理
     * @param crWarnProcessDTO
     * @return
     */
    void process(CrWarnProcessDTO crWarnProcessDTO);

    /**
     * 根据事件ID查询预警处理记录
     * @param eventId
     * @return
     */
    List<CrWarnProcess> getProcessRecords(Long eventId);

    /**
     * 分发预警
     * @param eventId
     * @param handlerId
     * @return
     */
    void distribute(DistributeDTO distributeDTO);
}
