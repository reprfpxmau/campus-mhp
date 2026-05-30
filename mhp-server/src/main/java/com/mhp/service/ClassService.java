package com.mhp.service;

import com.mhp.entity.SysClass;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClassService {
    /**
     * 根据学院ID查询班级列表
     * @param collegeId 学院ID
     * @return 班级列表
     */
    List<SysClass> list(Long collegeId);
}
