package com.mhp.service.impl.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhp.dto.admin.CrWarnProcessDTO;
import com.mhp.dto.admin.DistributeDTO;
import com.mhp.dto.admin.WarnPageQueryDTO;
import com.mhp.entity.CrRiskAssessment;
import com.mhp.entity.CrWarnProcess;
import com.mhp.mapper.admin.WarnMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.WarnService;
import com.mhp.vo.admin.WarnPageQueryVO;

import java.util.List;

import com.mhp.context.BaseContext;

import org.springframework.beans.BeanUtils;
import java.time.LocalDateTime;
import com.mhp.entity.CrWarnEvent;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WarnServiceImpl implements WarnService {
    @Autowired
    private WarnMapper warnMapper;

    
    /**
     * 分页查询预警
     * @param warnPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(WarnPageQueryDTO warnPageQueryDTO) {
        Long userId = BaseContext.getCurrentId();
        String role = BaseContext.getCurrentRole();
        if ("counselor".equals(role)) {
            warnPageQueryDTO.setHandlerId(userId);
        } else if ("student".equals(role)) {
            warnPageQueryDTO.setStudentId(userId);
        }
        PageHelper.startPage(warnPageQueryDTO.getPage(),warnPageQueryDTO.getPageSize());
        Page<WarnPageQueryVO> page = warnMapper.pageQuery(warnPageQueryDTO);
        Long total = page.getTotal();
        List<WarnPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }



    /**
     * 预警评估详情
     * @param assessmentId
     * @return
     */
    @Override
    public CrRiskAssessment getDetail(Long assessmentId) {
        CrRiskAssessment crRiskAssessment = warnMapper.getDetail(assessmentId);
        return crRiskAssessment;
    }
    /**
     * 预警处理
     * @param crWarnProcessDTO
     * @return
     */
    @Override
    @Transactional
    public void process(CrWarnProcessDTO crWarnProcessDTO) {
        CrWarnProcess crWarnProcess = new CrWarnProcess();
        BeanUtils.copyProperties(crWarnProcessDTO, crWarnProcess);

        //获取当前登录用户ID
        Long userId = BaseContext.getCurrentId();
        //设置处理人ID为当前登录用户ID
        crWarnProcess.setHandlerId(userId);
        //设置当前处理时间为当前时间
        crWarnProcess.setProcessTime(LocalDateTime.now());

        //如果需要跟进，设置跟进计划 并将事件状态设置为处理中
        CrWarnEvent crWarnEvent = new CrWarnEvent();
        crWarnEvent.setEventId(crWarnProcess.getEventId());

            //判定是否需要跟进
        if(Boolean.TRUE.equals(crWarnProcessDTO.getNeedFollowUp())) {
            // 将旧的跟踪记录设置为已完成
            warnMapper.closeOpenProcesses(crWarnProcess.getEventId());
            // 设置当前处理状态为处理中 0处理中 1已完成
            crWarnProcess.setStatus(0);
            // 设置事件状态为处理中 2处理中 3已处理
            crWarnEvent.setEventStatus(2);
        }else{        
            //设置处理状态为已处理
            warnMapper.closeOpenProcesses(crWarnProcess.getEventId());
            crWarnProcess.setStatus(1);
            crWarnEvent.setEventStatus(3);
        }
            crWarnProcess.setFollowUpPlan(crWarnProcessDTO.getFollowUpPlan());
            warnMapper.insert(crWarnProcess);
            warnMapper.processUpdate(crWarnEvent);
    }

    /**
     * 根据事件ID查询预警处理记录
     * @param eventId
     * @return
     */
    @Override
    public List<CrWarnProcess> getProcessRecords(Long eventId) {
        return warnMapper.selectProcessByEventId(eventId);
    }

    /**
     * 分发预警
     * @param eventId
     * @param handlerId
     * @return
     */
    @Override
    @Transactional
    public void distribute(DistributeDTO distributeDTO) {
        CrWarnEvent crWarnEvent = new CrWarnEvent();
        crWarnEvent.setEventId(distributeDTO.getEventId());
        crWarnEvent.setHandlerId(distributeDTO.getHandlerId());
        crWarnEvent.setEventStatus(1);  // 待处理
        warnMapper.distributeUpdate(crWarnEvent);
    }
}
