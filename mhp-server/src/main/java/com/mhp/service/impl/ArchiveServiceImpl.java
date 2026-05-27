package com.mhp.service.impl;

import com.mhp.service.ArchiveService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mhp.dto.ArchivePageQueryDTO;
import com.mhp.result.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.mapper.ArchiveMapper;
import com.mhp.entity.MhArchive;
import java.util.List;
import com.github.pagehelper.Page;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArchiveMapper archiveMapper;
    /**
     * 分页查询用户档案
     * @param archivePageQueryDTO 分页查询参数
     * @return 分页结果
     */
    @Override
    public PageResult pageQuery(ArchivePageQueryDTO archivePageQueryDTO) {
        PageHelper.startPage(archivePageQueryDTO.getPage(),archivePageQueryDTO.getPageSize());
        Page<MhArchive> page = archiveMapper.pageQuery(archivePageQueryDTO);
        Long total = page.getTotal();
        List<MhArchive> records = page.getResult();
        return new PageResult(total,records);
    }
    
}
