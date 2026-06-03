package com.mhp.service.admin;

import com.mhp.dto.admin.ArchiveVersionPageQueryDTO;
import com.mhp.result.PageResult;

public interface ArchiveVersionService {
    PageResult pageQuery(ArchiveVersionPageQueryDTO dto);
}
