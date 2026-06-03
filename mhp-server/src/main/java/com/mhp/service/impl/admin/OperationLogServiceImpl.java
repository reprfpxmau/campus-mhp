package com.mhp.service.impl.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.dto.admin.OperationLogPageQueryDTO;
import com.mhp.mapper.admin.OperationLogMapper;
import com.mhp.result.PageResult;
import com.mhp.service.admin.OperationLogService;
import com.mhp.vo.admin.OperationLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public PageResult pageQuery(OperationLogPageQueryDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<OperationLogVO> page = operationLogMapper.pageQuery(dto);
        Long total = page.getTotal();
        List<OperationLogVO> records = page.getResult();
        return new PageResult(total, records);
    }
}
