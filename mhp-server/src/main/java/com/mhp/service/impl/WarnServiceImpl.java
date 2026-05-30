package com.mhp.service.impl;
import com.mhp.mapper.WarnMapper;
import com.mhp.service.WarnService;
import com.mhp.vo.WarnPageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.entity.CrRiskAssessment;
import com.mhp.entity.CrWarnProcess;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.result.PageResult;
import java.util.List;

import com.mhp.context.BaseContext;
import com.mhp.dto.CrWarnProcessDTO;
import org.springframework.beans.BeanUtils;
import java.time.LocalDateTime;

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
        // 获取当前登录的用户id和角色
        Long userId = BaseContext.getCurrentId();
        String role = BaseContext.getCurrentRole();
        // 咨询师只查自己被分配的预警
        if("counselor".equals(role)) {
            warnPageQueryDTO.setHandlerId(userId);
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
    public PageResult getDetail(String assessmentId) {
        Page<CrRiskAssessment> page = warnMapper.getDetail(assessmentId);
        Long total = page.getTotal();
        List<CrRiskAssessment> records = page.getResult();
        return new PageResult(total, records);
    }
    /**
     * 预警处理
     * @param crWarnProcessDTO
     * @return
     */
    @Override
    public void process(CrWarnProcessDTO crWarnProcessDTO) {
        CrWarnProcess crWarnProcess = new CrWarnProcess();
        BeanUtils.copyProperties(crWarnProcessDTO, crWarnProcess);

        //获取当前登录用户ID
        Long userId = BaseContext.getCurrentId();
        //设置处理人ID为当前登录用户ID
        crWarnProcess.setHandlerId(userId);
        //设置当前处理时间为当前时间
        crWarnProcess.setProcessTime(LocalDateTime.now());
        //设置处理状态为已处理
        crWarnProcess.setStatus(1);
        warnMapper.insert(crWarnProcess);
        
    }
}
