package com.mhp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import com.mhp.entity.PsyScale;
import com.mhp.vo.ScaleVO;
import com.mhp.entity.PsyOption;
import com.mhp.dto.ScalePageQueryDTO;
import org.apache.ibatis.annotations.Select;
import com.mhp.vo.PsyQuestionVO;
import java.util.List;

@Mapper
public interface ScaleMapper {
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    Page<PsyScale> pageQuery(ScalePageQueryDTO scalePageQueryDTO);

    /**
     * 新增心理量表
     * @param psyScale 心理量表
     */
    void insert(PsyScale psyScale);


    /**
     * 根据量表编码查询
     * @param scaleCode 量表编码
     * @return 量表
     */
    Integer selectByScaleCode(String scaleCode);

    /**
     * 更新心理量表
     * @param psyScale 心理量表
     */
    void update(PsyScale psyScale);
    /**
     * 获取量表状态
     * @param scaleId 量表ID
     * @return 量表状态
     */
    @Select("select status from psy_scale where scale_id = #{scaleId}")
    Integer selectStatusById(Long scaleId);


    /**
     * 根据量表ID查询
     * @param scaleId 量表ID
     * @return 量表
     */
    ScaleVO selectById(Long scaleId);
    
    /**
     * 根据量表ID查询题目表
     * @param scaleId 量表ID
     * @return 题目列表
     */
    List<PsyQuestionVO> selectByScaleQuestion(Long scaleId);
    
    /**
     * 根据题目ID查询选项表
     * @param questionIds 题目ID列表
     * @return 选项列表
     */
    List<PsyOption> selectByScaleOption(List<Long> questionIds);



}