package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;

import com.mhp.result.PageResult;
import com.mhp.service.admin.AppointmentService;
import com.mhp.vo.admin.AppointmentPageQueryVO;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.context.BaseContext;
import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.entity.CsAppointment;
import com.mhp.entity.CsConsultSession;
import com.mhp.mapper.admin.AppointmentMapper;
import com.mhp.dto.admin.AppointmentDTO;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import com.mhp.vo.admin.completedStudentsVO;
import com.mhp.mapper.admin.ConsultMapper;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private ConsultMapper consultMapper;

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

    /**
     * 改派咨询师
     * @param appointmentDTO
     */
    @Override
    public void reassign(AppointmentDTO appointmentDTO) {
        appointmentMapper.reassign(appointmentDTO);
    }

    /**
     * 确认预约 0待确认 1已确认 2已拒绝 3已取消
     * @param id
     */
    @Override
    @Transactional
    public void confirm(Long id) {
        //查找预约记录
        CsAppointment appointment = appointmentMapper.selectById(id);
        // 确认预约后，将预约状态改为已确认
        // TODO通知学生预约已被确认
        LocalDateTime confirmTime = LocalDateTime.now();
        appointmentMapper.updateStatus(id, 1, confirmTime);

        //新建咨询会话
        CsConsultSession session = CsConsultSession.builder()
        .appointmentId(id)
        .studentId(appointment.getStudentId())
        .counselorId(appointment.getCounselorId())
        .status(0)             // 进行中
        .startTime(LocalDateTime.now())
        .build();
        consultMapper.insert(session);
    }

    /**
     * 拒绝预约 0待确认 1已确认 2已拒绝 3已取消
     * @param id
     */
    @Override
    public void reject(Long id) {
        // 拒绝预约后，将预约状态改为已拒绝  并等待管理员重新分发 

        // TODO通知管理员预约已被拒绝
        LocalDateTime rejectTime = LocalDateTime.now();
        appointmentMapper.updateStatus(id, 2, rejectTime);
    }

    /**
     * 取消预约 0待确认 1已确认 2已拒绝 3已取消
     * @param id
     */
    @Override
    public void cancel(Long id) {
        // 取消预约后，将预约状态改为已取消
        // TODO通知学生预约已被取消
        LocalDateTime cancelTime = LocalDateTime.now();
        appointmentMapper.updateStatus(id, 3, cancelTime);
    }

    /**
     * 查询已完成预约的学生
     * 无 （咨询师登录后自动筛选自己的预约）
     * @return
     */
    @Override
    public List<completedStudentsVO> completedStudents() {
        Long userId = BaseContext.getCurrentId();
        return appointmentMapper.completedStudents(userId);
    }
}
