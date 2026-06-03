package com.mhp.service.impl.admin;

import com.github.pagehelper.PageHelper;
import com.mhp.dto.admin.ConsultDTO;
import com.mhp.result.PageResult;
import com.mhp.service.admin.ConsultService;
import com.mhp.entity.CsConsultRecord;
import com.mhp.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mhp.mapper.admin.ConsultMapper;
import com.github.pagehelper.Page;
import java.util.List;
import com.mhp.dto.admin.ConsultRecordDTO;
import com.mhp.vo.admin.ConsultPageQueryVO;
import com.mhp.context.BaseContext;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ConsultServiceImpl implements ConsultService {
    @Autowired
    private ConsultMapper consultMapper;
    
    /**
     * 分页查询咨询记录
     * @param consultDTO
     * @return
     */
    @Override
    public PageResult pageQuery(ConsultDTO consultDTO) {
        Long userId = BaseContext.getCurrentId();
        String role = BaseContext.getCurrentRole();
        if (role != null && role.equals("counselor")) {
            consultDTO.setCounselorId(userId);
        }
        PageHelper.startPage(consultDTO.getPage(), consultDTO.getPageSize());
        Page<ConsultPageQueryVO> page = consultMapper.pageQuery(consultDTO);
        Long total = page.getTotal();
        List<ConsultPageQueryVO> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 创建并更新咨询记录
     * @param consultRecordDTO
     */
    @Override
    @Transactional
    public void add(ConsultRecordDTO consultRecordDTO) {
        Long counselorId = BaseContext.getCurrentId();
        //查询咨询会话ID
        Long sessionId = consultMapper.getSessionId(consultRecordDTO.getAppointmentId(), counselorId);
        consultRecordDTO.setSessionId(sessionId);
        // 新增咨询记录
        CsConsultRecord consultRecord = CsConsultRecord.builder()
                .sessionId(sessionId)
                .counselorId(counselorId)
                .studentId(consultRecordDTO.getStudentId())
                .chiefComplaint(consultRecordDTO.getChiefComplaint())
                .consultProcess(consultRecordDTO.getConsultProcess())
                .assessment(consultRecordDTO.getAssessment())
                .suggestion(consultRecordDTO.getSuggestion())
                .archiveStatus(1) 
                .build();
        consultMapper.insertRecord(consultRecord);
        // 更新咨询预约状态为已完成
        consultMapper.updateAppointmentStatus(consultRecordDTO.getAppointmentId(), 4);
        // 更新咨询会话状态为已完成
        consultMapper.updateSessionStatus(sessionId, 1);

        
    }
}
