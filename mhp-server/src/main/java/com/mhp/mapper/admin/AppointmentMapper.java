package com.mhp.mapper.admin;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.vo.admin.AppointmentPageQueryVO;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.dto.admin.AppointmentDTO;
import java.time.LocalDateTime;
import com.mhp.vo.admin.completedStudentsVO;
import java.util.List;
import com.mhp.entity.CsAppointment;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppointmentMapper {
    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    Page<AppointmentPageQueryVO> pageQuery(AppointmentPageQueryDTO appointmentPageQueryDTO);

    /**
     * 改派咨询师
     * @param appointmentDTO
     * @return
     */
    void reassign(AppointmentDTO appointmentDTO);

    /**
     * 更新预约状态
     * @param id
     * @param status
     * @return
     */
    void updateStatus(Long id, Integer status, LocalDateTime confirmTime);

    /**
     * 查找预约记录
     * @param id
     * @return
     */
    @Select("select * from cs_appointment where appointment_id = #{id}")
    CsAppointment selectById(Long id);

    /**
     * 查询当前咨询师已完成预约的学生
     * @return
     */
    List<completedStudentsVO> completedStudents(Long userId);
    
}
