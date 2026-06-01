package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.dto.admin.ExamPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.vo.admin.ExamReportVO;

@Service
public interface ExamService {
    /**
     * 分页查询测评记录
     * @param examPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    PageResult pageQuery(ExamPageQueryDTO examPageQueryDTO);
    /**
     * 测评报告详情
     * @param recordId 测评报告ID
     * @return 测评报告
     */
    ExamReportVO getReport(Long recordId);
}
