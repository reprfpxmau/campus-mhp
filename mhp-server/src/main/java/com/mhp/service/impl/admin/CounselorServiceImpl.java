package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhp.mapper.admin.CounselorMapper;
import com.mhp.service.admin.CounselorService;
import com.mhp.vo.admin.CounselorPageQueryVO;

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
