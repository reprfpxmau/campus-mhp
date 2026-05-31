package com.mhp.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.mapper.ScaleMapper;
import com.mhp.entity.PsyScale;
import com.mhp.exception.BusinessException;
import com.mhp.service.ScaleService;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
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
}
