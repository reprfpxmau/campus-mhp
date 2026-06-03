package com.mhp.service.user;

import com.mhp.dto.admin.ConsultDTO;
import com.mhp.result.PageResult;
import com.mhp.vo.admin.ConsultPageQueryVO;

public interface UserConsultService {
    PageResult myRecords(ConsultDTO dto);
    ConsultPageQueryVO getDetail(Long recordId);
}
