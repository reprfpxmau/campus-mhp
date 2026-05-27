package com.mhp.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.ScalePageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.mapper.ScaleMapper;
import com.mhp.entity.PsyScale;
import com.mhp.service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    
}
