package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;

import com.mhp.service.admin.CollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.mhp.entity.SysCollege;
import com.mhp.mapper.admin.CollegeMapper;

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
