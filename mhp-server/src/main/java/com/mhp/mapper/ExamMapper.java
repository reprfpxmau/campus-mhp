package com.mhp.mapper;

import com.mhp.vo.ExamPageQueryVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import com.mhp.dto.ExamPageQueryDTO;

@Mapper
public interface ExamMapper {
    /**
     * 分页查询测评记录
     * @param examPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<ExamPageQueryVO> pageQuery(ExamPageQueryDTO examPageQueryDTO);
}
