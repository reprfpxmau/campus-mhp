package com.mhp.service;
import org.springframework.stereotype.Service;
import com.mhp.dto.WarnPageQueryDTO;
import com.mhp.result.PageResult;

@Service
public interface WarnService {
    /**
     * 分页查询预警
     * @param warnPageQueryDTO
     * @return
     */
    PageResult pageQuery(WarnPageQueryDTO warnPageQueryDTO);
    /**
     * 预警评估详情
     * @param assessmentId
     * @return
     */
    PageResult getDetail(String assessmentId);
}
