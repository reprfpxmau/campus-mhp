package com.mhp.service.user;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;

public interface UserAppointmentService {
    PageResult myAppointments(AppointmentPageQueryDTO dto);
    void cancel(Long appointmentId);
}
