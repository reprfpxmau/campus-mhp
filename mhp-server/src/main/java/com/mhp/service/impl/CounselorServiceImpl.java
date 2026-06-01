package com.mhp.service.impl;

import com.mhp.service.CounselorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhp.mapper.CounselorMapper;
import com.mhp.vo.CounselorPageQueryVO;
import java.util.List;

@Service
public class CounselorServiceImpl implements CounselorService {

    @Autowired
    private CounselorMapper counselorMapper;

    @Override
    public List<CounselorPageQueryVO> list() {
        return counselorMapper.list();
    }
}
