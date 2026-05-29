package com.mhp.service.impl;
import com.mhp.mapper.WarnMapper;
import com.mhp.service.WarnService;
import com.mhp.vo.WarnPageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.entity.CrRiskAssessment;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhp.result.PageResult;
import java.util.List;

@Service
public class WarnServiceImpl implements WarnService {
    @Autowired
    private WarnMapper warnMapper;
    
    /**
     * 分页查询预警
     * @param warnPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(WarnPageQueryDTO warnPageQueryDTO) {
        PageHelper.startPage(warnPageQueryDTO.getPage(),warnPageQueryDTO.getPageSize());
        Page<WarnPageQueryVO> page = warnMapper.pageQuery(warnPageQueryDTO);
        Long total = page.getTotal();
        List<WarnPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }
    /**
     * 预警评估详情
     * @param assessmentId
     * @return
     */
    @Override
    public PageResult getDetail(String assessmentId) {
        Page<CrRiskAssessment> page = warnMapper.getDetail(assessmentId);
        Long total = page.getTotal();
        List<CrRiskAssessment> records = page.getResult();
        return new PageResult(total, records);
    }
}
