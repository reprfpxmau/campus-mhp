package com.mhp.service.impl.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.context.BaseContext;
import com.mhp.dto.admin.ConsultDTO;
import com.mhp.mapper.admin.ConsultMapper;
import com.mhp.result.PageResult;
import com.mhp.service.user.UserConsultService;
import com.mhp.vo.admin.ConsultPageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConsultServiceImpl implements UserConsultService {
    @Autowired
    private ConsultMapper consultMapper;

    @Override
    public PageResult myRecords(ConsultDTO dto) {
        Long studentId = BaseContext.getCurrentId();
        dto.setStudentId(studentId);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<ConsultPageQueryVO> page = consultMapper.pageQuery(dto);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public ConsultPageQueryVO getDetail(Long recordId) {
        return consultMapper.selectById(recordId);
    }
}
