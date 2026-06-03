package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.dto.admin.AppointmentDTO;
import java.util.List;
import com.mhp.vo.admin.completedStudentsVO;

@Service
public interface AppointmentService {
    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    PageResult pageQuery(AppointmentPageQueryDTO appointmentPageQueryDTO);

    /**
     * 改派咨询师
     * @param appointmentDTO
     */
    void reassign(AppointmentDTO appointmentDTO);

    /**
     * 确认预约
     * @param id
     */
    void confirm(Long id);

    /**
     * 拒绝预约
     * @param id
     */
    void reject(Long id);

    /**
     * 取消预约
     * @param id
     */
    void cancel(Long id);

    /**
     * 查询已完成预约的学生
     * @param id
     * @return
     */
    List<completedStudentsVO> completedStudents();
}
