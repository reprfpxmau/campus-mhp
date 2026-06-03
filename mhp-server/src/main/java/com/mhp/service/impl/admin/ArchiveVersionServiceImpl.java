package com.mhp.service.impl.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.admin.ArchiveVersionPageQueryDTO;
import com.mhp.mapper.admin.ArchiveVersionMapper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.ArchiveVersionService;
import com.mhp.vo.admin.ArchiveVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveVersionServiceImpl implements ArchiveVersionService {
    @Autowired
    private ArchiveVersionMapper archiveVersionMapper;

    @Override
    public PageResult pageQuery(ArchiveVersionPageQueryDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<ArchiveVersionVO> page = archiveVersionMapper.pageQuery(dto);
        Long total = page.getTotal();
        List<ArchiveVersionVO> records = page.getResult();
        return new PageResult(total, records);
    }
}
