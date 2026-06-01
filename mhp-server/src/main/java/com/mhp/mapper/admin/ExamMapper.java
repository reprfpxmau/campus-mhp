package com.mhp.mapper.admin;

import com.mhp.dto.admin.ExamPageQueryDTO;
import com.mhp.vo.admin.ExamPageQueryVO;
import com.mhp.vo.admin.ExamReportVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamMapper {
    /**
     * 分页查询测评记录
     * @param examPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<ExamPageQueryVO> pageQuery(ExamPageQueryDTO examPageQueryDTO);

    /**
     * 测评报告详情
     * @param recordId 测评报告ID
     * @return 测评报告
     */
    ExamReportVO selectReport(Long recordId);
}
