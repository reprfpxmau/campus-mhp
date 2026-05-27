package com.mhp.mapper;

import com.mhp.dto.AppointmentPageQueryDTO;
import com.mhp.vo.AppointmentPageQueryVO;
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
