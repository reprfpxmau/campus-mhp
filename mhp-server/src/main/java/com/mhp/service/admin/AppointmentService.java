package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
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
