package com.mhp.service.admin;

import com.mhp.result.PageResult;
import org.springframework.stereotype.Service;
import com.mhp.dto.admin.ConsultDTO;
import com.mhp.dto.admin.ConsultRecordDTO;

@Service
public interface ConsultService {
    /**
     * 分页查询咨询记录
     * @param consultDTO
     * @return
     */
    PageResult pageQuery(ConsultDTO consultDTO);

    /**
     * 新增咨询记录
     * @param consultRecordDTO
     */
    void add(ConsultRecordDTO consultRecordDTO);
}
