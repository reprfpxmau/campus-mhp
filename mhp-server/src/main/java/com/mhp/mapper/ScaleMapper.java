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
import com.mhp.entity.PsyQuestionDTO;

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

    /**
     * 新增题目
     * @param psyQuestionDTO 题目DTO
     */
    void insertQuestion(PsyQuestionDTO psyQuestionDTO);
    /**
     * 新增选项
     * @param options 选项列表
     */
    void insertByOptions(List<PsyOption> options);
    
    /**
     * 根据题目号查询
     * @param questionNo 题目号
     * @return 题目
     */
    Integer selectByQuestionNo(Long scaleId,String questionNo);

    /**
     * 删除题目
     * @param id 题目ID
     */
    void deleteQuestion(Long id);
    /**
     * 删除选项
     * @param questionId 题目ID
     */
    void deleteByQuestionId(Long questionId);
    /**
     * 查询量表数据
     * @param psyQuestionDTO 题目DTO
     */
    @Select("select * from psy_scale where scale_id = #{scaleId}")
    PsyScale selectScaleById(Long scaleId);

    /**
     * 根据题目ID查询量表ID
     * @param questionId 题目ID
     * @return 量表ID
     */
    @Select("select scale_id from psy_question where question_id = #{questionId}")
    Long selectScaleIdByQuestionId(Long questionId);

    /**
     * 根据量表ID列表查询量表状态
     * @param scaleIds 量表ID列表
     * @return 量表状态列表
     */
    List<Integer> selectStatusByIds(List<Long> scaleIds);

    /**
     * 批量删除量表
     * @param scaleIds 量表ID列表
     */
    void batchDeleteScale(List<Long> scaleIds);
    /**
     * 批量删除题目
     * @param scaleIds 量表ID列表
     */
    void batchByScaleQuestion(List<Long> scaleIds);
    
    /**
     * 根据量表ID列表查询题目ID列表
     * @param scaleIds 量表ID列表
     * @return 题目ID列表
     */
    List<Long> selectByScaleQuestionIds(List<Long> scaleIds);
    /**
     * 批量删除选项
     * @param questionIds 题目ID列表
     */
    void batchByScaleOption(List<Long> questionIds);
}