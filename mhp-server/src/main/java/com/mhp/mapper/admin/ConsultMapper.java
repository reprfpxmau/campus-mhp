package com.mhp.mapper.admin;

import com.mhp.dto.admin.ConsultDTO;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.vo.admin.ConsultPageQueryVO;
import com.mhp.entity.CsConsultSession;
import com.mhp.entity.CsConsultRecord;



@Mapper
public interface ConsultMapper {
    /**
     * 分页查询咨询记录
     * @param consultDTO
     * @return
     */
    Page<ConsultPageQueryVO> pageQuery(ConsultDTO consultDTO);

    /**
     * 新增咨询会话
     * @param consultSession
     */
    void insert(CsConsultSession consultSession);

    /**
     * 创建并更新咨询记录
     * @param consultSession
     */
    void insertRecord(CsConsultRecord consultRecord);

    /**
     * 查询咨询会话ID
     * @param appointmentId
     * @param counselorId
     * @return
     */
    Long getSessionId(Long appointmentId, Long counselorId);

    /**
     * 更新咨询预约状态
     * @param sessionId
     * @param status
     */
    void updateAppointmentStatus(Long appointmentId, Integer status);
    /**
     * 更新咨询会话状态
     * @param sessionId
     * @param status
     */
    void updateSessionStatus(Long sessionId, Integer status);

    /**
     * 根据记录ID查询咨询记录详情
     * @param recordId
     * @return
     */
    ConsultPageQueryVO selectById(Long recordId);
}
