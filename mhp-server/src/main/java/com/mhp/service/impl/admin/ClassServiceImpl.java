package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;

import com.mhp.service.admin.ClassService;
import com.mhp.entity.SysClass;
import com.mhp.mapper.admin.ClassMapper;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    /**
     * 根据学院ID查询班级列表
     * @param collegeId 学院ID
     * @return 班级列表
     */
    @Override
    public List<SysClass> list(Long collegeId) {
        return classMapper.listByCollegeId(collegeId);
    }
}
