package com.mhp.service.impl;

import org.springframework.stereotype.Service;
import com.mhp.dto.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.service.AppointmentService;
import com.mhp.vo.AppointmentPageQueryVO;
import java.util.List;
import com.mhp.mapper.AppointmentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.context.BaseContext;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 分页查询预约记录
     * @param appointmentPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(AppointmentPageQueryDTO appointmentPageQueryDTO) {
        Long userId = BaseContext.getCurrentId();
        String role = BaseContext.getCurrentRole();
        // 咨询师只查自己被预约的
        if ("counselor".equals(role)) {
            appointmentPageQueryDTO.setCounselorId(userId);
        }
        PageHelper.startPage(appointmentPageQueryDTO.getPage(), appointmentPageQueryDTO.getPageSize());
        Page<AppointmentPageQueryVO> page = appointmentMapper.pageQuery(appointmentPageQueryDTO);
        Long total = page.getTotal();
        List<AppointmentPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }
}
