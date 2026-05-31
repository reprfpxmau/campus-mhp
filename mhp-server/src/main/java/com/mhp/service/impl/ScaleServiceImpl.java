package com.mhp.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.mapper.ScaleMapper;
import com.mhp.entity.PsyScale;
import com.mhp.vo.ScaleVO;
import com.mhp.vo.PsyQuestionVO;
import com.mhp.entity.PsyOption;
import com.mhp.exception.BusinessException;
import com.mhp.service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import com.mhp.constant.MessageConstant;

@Service
public class ScaleServiceImpl implements ScaleService {
    @Autowired
    private ScaleMapper scaleMapper;
    
    
    /**
     * 分页查询心理量表
     * @param scalePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @Override
    public PageResult pageQuery(ScalePageQueryDTO scalePageQueryDTO) {
        PageHelper.startPage(scalePageQueryDTO.getPage(),scalePageQueryDTO.getPageSize());
        Page<PsyScale> page = scaleMapper.pageQuery(scalePageQueryDTO);
        Long total = page.getTotal();
        List<PsyScale> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 新增心理量表
     * @param psyScale 心理量表
     */
    @Override
    public void add(PsyScale psyScale) {
        Integer scaleCount = scaleMapper.selectByScaleCode(psyScale.getScaleCode());
        if (scaleCount > 0) {
            throw new BusinessException(MessageConstant.SCALE_CODE_EXIST);
        }
                psyScale.setStatus(0);
                psyScale.setIsBuiltIn(0);
                psyScale.setCreateTime(LocalDateTime.now());
                psyScale.setUpdateTime(LocalDateTime.now());
        scaleMapper.insert(psyScale);
    }

    /**
     * 更新心理量表
     * @param psyScale 心理量表
     */
    @Override
    public void update(PsyScale psyScale) {
        Integer status = scaleMapper.selectStatusById(psyScale.getScaleId());
        if (status == 1) {
            throw new BusinessException(MessageConstant.SCALE_STATUS_ERROR);
        }
        psyScale.setUpdateTime(LocalDateTime.now());
        scaleMapper.update(psyScale);
    }

    /**
     * 更新心理量表状态
     * @param status 状态：0=禁用 1=正常
     * @param scaleId 量表ID
     */
    @Override
    public void updateStatus(Integer status, Long scaleId) {
        PsyScale psyScale = PsyScale.builder()
                .scaleId(scaleId)
                .status(status)
                .build();
        scaleMapper.update(psyScale);
    }

    /**
     * 根据量表ID查询心理量表详情
     * @param scaleId 量表ID
     * @return 心理量表详情
     */
    @Override
    public ScaleVO selectById(Long scaleId) {
        //  查询量表详情
        ScaleVO scaleVO = scaleMapper.selectById(scaleId);

        //  根据量表ID查询题目列表
        List <PsyQuestionVO> questions = scaleMapper.selectByScaleQuestion(scaleId);

        // 获取题目号列表
            // 用来存储题目号列表
        List<Long> questionIds = new ArrayList<>();
            // 遍历题目列表，获取题目主键
        if (questions != null && !questions.isEmpty()) {
        for (PsyQuestionVO question : questions) {
                // 将题目主键添加到列表
            questionIds.add(question.getQuestionId());
            }
        }
        
        // 根据题目id查询选项列表
        if (questionIds != null && !questionIds.isEmpty()) {
            // 根据题目id列表查询选项列表
            List <PsyOption> options = scaleMapper.selectByScaleOption(questionIds);
            //将选项列表添加到题目列表
            questions.forEach(question -> {
                // 选项列表
                List<PsyOption> optionList = new ArrayList<>();
                for (PsyOption option : options) {
                    if (question.getQuestionId().equals(option.getQuestionId())) {
                    optionList.add(option);
                    }
                }
                question.setOptionList(optionList);
            });
        }
        scaleVO.setQuestions(questions);
        return scaleVO;
    }
}
