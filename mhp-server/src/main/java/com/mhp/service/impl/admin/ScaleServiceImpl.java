package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.ScaleService;
import com.mhp.vo.admin.PsyQuestionVO;
import com.mhp.vo.admin.ScaleVO;
import com.mhp.entity.PsyScale;
import com.mhp.entity.PsyOption;
import com.mhp.exception.BusinessException;
import com.mhp.mapper.admin.ScaleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import com.mhp.constant.MessageConstant;
import com.mhp.dto.admin.ScalePageQueryDTO;
import com.mhp.entity.PsyQuestionDTO;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 新增题目
     * @param scaleId 量表ID
     * @return
     */
    @Transactional
    @Override
    public void addQuestion(PsyQuestionDTO psyQuestionDTO) {
        // 验证量表状态是否为禁用
        Integer status = scaleMapper.selectStatusById(psyQuestionDTO.getScaleId());
        if (status == 1) {
            throw new BusinessException(MessageConstant.SCALE_STATUS_ERROR);
        }
        // 验证题目号是否存在
        Integer questionCount = scaleMapper.selectByQuestionNo(psyQuestionDTO.getScaleId(),psyQuestionDTO.getQuestionNo());
        if (questionCount > 0) {
            throw new BusinessException(MessageConstant.QUESTION_NO_EXIST);
        }
        // 新增题目
        scaleMapper.insertQuestion(psyQuestionDTO);
            // 获取新增题目主键
        Long questionId = psyQuestionDTO.getQuestionId();
        // 新增选项
        List<PsyOption> options = psyQuestionDTO.getOptions();
        if (options != null && !options.isEmpty()) {
            // 遍历选项列表，添加题目id
            options.forEach(option -> {
                option.setQuestionId(questionId);
            });
            scaleMapper.insertByOptions(options);
        }
        // 更新量表
        PsyScale psyScale = PsyScale.builder()
                .scaleId(psyQuestionDTO.getScaleId())
                .questionCount(questionCount + 1)
                .build();
        scaleMapper.update(psyScale);
    }

    /**
     * 删除题目
     * @param id 题目ID
     */
    @Transactional
    @Override
    public void deleteQuestion(Long id) {
        // 获取量表id
        Long scaleId = scaleMapper.selectScaleIdByQuestionId(id);
        // 验证量表状态是否为禁用
        Integer status = scaleMapper.selectStatusById(scaleId);
        if (status == 1) {
            throw new BusinessException(MessageConstant.SCALE_STATUS_ERROR);
        }
        //删除题目
        scaleMapper.deleteQuestion(id);
        //删除选项
        scaleMapper.deleteByQuestionId(id);

        // 更新量表
        PsyScale psyScale = scaleMapper.selectScaleById(scaleId);
        Integer questionCount = psyScale.getQuestionCount();
        psyScale = PsyScale.builder()
                .scaleId(scaleId)
                .questionCount(questionCount - 1)
                .build();
        scaleMapper.update(psyScale);
    }

    /**
     * 批量删除量表
     * @param scaleIds 量表ID列表
     */
    @Transactional
    @Override
    public void batchDeleteScale(List<Long> scaleIds) {
        List<Integer> statusList = scaleMapper.selectStatusByIds(scaleIds);
        statusList.forEach(status -> {
            Integer scaleStatus = status;
            if (scaleStatus == 1) {
                throw new BusinessException(MessageConstant.SCALE_STATUS_ERROR_DELETE);
            }
        });
        // 获取所有要删除的题目id
        List<Long> questionIds = scaleMapper.selectByScaleQuestionIds(scaleIds);
        
        // 批量删除量表
        scaleMapper.batchDeleteScale(scaleIds);
        if (questionIds != null && !questionIds.isEmpty()) {
            // 删除题目
            scaleMapper.batchByScaleQuestion(scaleIds);
        }
        if (questionIds != null && !questionIds.isEmpty()) {
            // 删除选项
            scaleMapper.batchByScaleOption(questionIds);
        }
    }
}
