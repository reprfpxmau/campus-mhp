package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface AppointmentService {
    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    PageResult pageQuery(AppointmentPageQueryDTO appointmentPageQueryDTO);
}
