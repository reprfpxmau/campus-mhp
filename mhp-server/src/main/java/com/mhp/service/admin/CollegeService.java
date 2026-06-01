package com.mhp.service.admin;

import org.springframework.stereotype.Service;
import com.mhp.entity.SysCollege;
import java.util.List;

@Service
public interface CollegeService {
    /**
     * 分页查询学院
     * @param collegePageQueryDTO
     * @return
     */
    List<SysCollege> list();
}
