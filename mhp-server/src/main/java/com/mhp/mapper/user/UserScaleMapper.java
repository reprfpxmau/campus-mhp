package com.mhp.mapper.user;

import com.mhp.entity.PsyScale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import com.mhp.vo.user.ScaleVO;
import com.mhp.vo.user.OptionVO;
import com.mhp.vo.user.QuestionsVO;

@Mapper
public interface UserScaleMapper {

    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    List<PsyScale> scaleList();
    
    /**
     * 查询当前测试项
     * @param scaleId 测试项ID
     * @return 当前测试项
     */
    @Select("select * from psy_scale where scale_id = #{scaleId}")
    ScaleVO scale(Integer scaleId);

    /**
     * 查询用户测试题目
     * @param scaleId 测试项ID
     * @return 测试题目
     */
    List<QuestionsVO> questions(Integer scaleId);

    /**
     * 查询用户测试选项（通过题目ID批量查询）
     * @param questionIds 题目ID列表
     * @return 测试选项
     */
    List<OptionVO> optionsByQuestionId(List<Long> questionIds);
}
