package com.mhp.service.impl;

import com.mhp.service.CollegeService;
import org.springframework.stereotype.Service;
import com.mhp.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.mhp.entity.SysCollege;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 分页查询学院
     */
    @Override
    public List<SysCollege> list() {
        return collegeMapper.list();
    }
}
