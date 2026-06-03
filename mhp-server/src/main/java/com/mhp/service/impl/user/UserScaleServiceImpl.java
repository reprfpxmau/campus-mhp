package com.mhp.service.impl.user;

import com.mhp.entity.PsyScale;
import org.springframework.stereotype.Service;
import com.mhp.mapper.user.UserScaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import com.mhp.result.Result;
import com.mhp.service.user.UserScaleService;
import com.mhp.vo.user.OptionVO;
import com.mhp.vo.user.QuestionsVO;
import com.mhp.vo.user.ScaleVO;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserScaleServiceImpl implements UserScaleService {
    @Autowired
    private UserScaleMapper userScaleMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    // 缓存键
    private final String CACHE_KEY = "exam:questions:";
    
    private String Key(Integer scaleId) {
        return CACHE_KEY + scaleId;
    }
    
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

    // 1. 先查缓存
    ScaleVO cached = (ScaleVO) redisTemplate.opsForValue().get(Key(scaleId));
    if (cached != null) {
        log.info("通过缓存查询到量表信息{}", scaleId);
        return cached;  // 命中缓存，直接返回
    }
    log.info("未命中缓存，从数据库查询量表{}", scaleId);
    // 1. 查量表信息
    ScaleVO scaleVO = userScaleMapper.scale(scaleId);
    
    // 2. 查题目
    List<QuestionsVO> questions = userScaleMapper.questions(scaleId);
    
    // 3. 提取题目ID列表
    List<Long> questionIds = new ArrayList<>();
    for (QuestionsVO q : questions) {
        questionIds.add(q.getQuestionId());
    }

    // 4. 查选项（通过题目ID批量查询）
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
       // 6. 缓存
    redisTemplate.opsForValue().set(Key(scaleId), scaleVO);
    log.info("缓存量表成功{}", scaleId);

    return scaleVO;
    }
}
