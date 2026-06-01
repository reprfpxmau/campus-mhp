package com.mhp.service.admin;

import com.mhp.result.Result;
import com.mhp.vo.admin.StatVO;

import org.springframework.stereotype.Service;

@Service
public interface StatService {
    /**
     * 统计总览
     * @return
     */
    Result<StatVO> overview();
}
