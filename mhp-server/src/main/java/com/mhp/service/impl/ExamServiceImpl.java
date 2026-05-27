package com.mhp.service.impl;

import org.springframework.stereotype.Service;
import com.mhp.mapper.ExamMapper;
import com.mhp.vo.ExamPageQueryVO;
import com.mhp.result.PageResult;
import com.mhp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.dto.ExamPageQueryDTO;
import com.github.pagehelper.Page;
import java.util.List;



@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    
    /**
     * 分页查询测评记录
     * @param examPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @Override
    public PageResult pageQuery(ExamPageQueryDTO examPageQueryDTO) {
        Page<ExamPageQueryVO> page = examMapper.pageQuery(examPageQueryDTO);
        Long total = page.getTotal();
        List<ExamPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }
}
