package com.mhp.mapper.admin;

import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.vo.admin.AppointmentPageQueryVO;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

@Mapper
public interface AppointmentMapper {
    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    Page<AppointmentPageQueryVO> pageQuery(AppointmentPageQueryDTO appointmentPageQueryDTO);
}
