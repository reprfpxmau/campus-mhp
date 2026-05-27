package com.mhp.service;

import org.springframework.stereotype.Service;
import com.mhp.dto.ExamPageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface ExamService {
    /**
     * 分页查询测评记录
     * @param examPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ExamPageQueryDTO examPageQueryDTO);
}
