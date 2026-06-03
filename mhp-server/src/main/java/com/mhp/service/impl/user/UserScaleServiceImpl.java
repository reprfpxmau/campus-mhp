package com.mhp.service.impl.user;

import com.mhp.entity.PsyScale;
import org.springframework.stereotype.Service;
import com.mhp.mapper.user.UserScaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.result.Result;
import com.mhp.service.user.UserScaleService;
import com.mhp.vo.user.OptionVO;
import com.mhp.vo.user.QuestionsVO;
import com.mhp.vo.user.ScaleVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserScaleServiceImpl implements UserScaleService {
    @Autowired
    private UserScaleMapper userScaleMapper;
    
    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    @Override
    public Result<List<PsyScale>> scaleList() {
    List<PsyScale> psyScale = userScaleMapper.scaleList();
        return Result.success(psyScale);
    }
    
    /**
     * 查询用户测试题目
     * @param scaleId 测试项ID
     * @return 测试题目
     */
    @Override
    public ScaleVO scale(Integer scaleId) {
    // 1. 查量表信息
    ScaleVO scaleVO = userScaleMapper.scale(scaleId);
    
    // 2. 查题目（不用 select *，手动指定字段，排除 is_reverse）
    List<QuestionsVO> questions = userScaleMapper.questions(scaleId);
    
    // 3. 提取题目ID列表
    List<Long> questionIds = new ArrayList<>();
    for (QuestionsVO q : questions) {
        questionIds.add(q.getQuestionId());
    }

    // 4. 查选项（空列表跳过，避免 SQL IN () 报错）
    if (!questionIds.isEmpty()) {
        List<OptionVO> options = userScaleMapper.optionsByQuestionId(questionIds);

        // 5. 把选项挂到对应题目上
        for (QuestionsVO q : questions) {
            List<OptionVO> matched = new ArrayList<>();
            for (OptionVO o : options) {
                if (o.getQuestionId().equals(q.getQuestionId())) {
                    matched.add(o);
                }
            }
            q.setOptions(matched);
        }
    }
    
    scaleVO.setQuestions(questions);
    return scaleVO;
}
}
