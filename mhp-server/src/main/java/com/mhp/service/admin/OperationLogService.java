package com.mhp.service.admin;

import com.mhp.dto.admin.OperationLogPageQueryDTO;
import com.mhp.result.PageResult;

public interface OperationLogService {
    PageResult pageQuery(OperationLogPageQueryDTO dto);
}
