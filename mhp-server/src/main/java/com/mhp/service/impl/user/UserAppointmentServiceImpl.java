package com.mhp.service.impl.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.constant.MessageConstant;
import com.mhp.context.BaseContext;
import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.entity.CsAppointment;
import com.mhp.exception.BusinessException;
import com.mhp.mapper.admin.AppointmentMapper;
import com.mhp.result.PageResult;
import com.mhp.service.user.UserAppointmentService;
import com.mhp.vo.admin.AppointmentPageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAppointmentServiceImpl implements UserAppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public PageResult myAppointments(AppointmentPageQueryDTO dto) {
        Long studentId = BaseContext.getCurrentId();
        dto.setStudentId(studentId);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<AppointmentPageQueryVO> page = appointmentMapper.pageQuery(dto);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void cancel(Long appointmentId) {
        CsAppointment appointment = appointmentMapper.selectById(appointmentId);
        if (appointment == null) {
            throw new BusinessException(MessageConstant.APPOINTMENT_NOT_FOUND);
        }
        if (!appointment.getStudentId().equals(BaseContext.getCurrentId())) {
            throw new BusinessException(MessageConstant.APPOINTMENT_NO_PERMISSION);
        }
        if (appointment.getStatus() != 0 && appointment.getStatus() != 1) {
            throw new BusinessException(MessageConstant.APPOINTMENT_STATUS_ERROR);
        }
        appointmentMapper.updateStatus(appointmentId, 3, null);
    }
}
