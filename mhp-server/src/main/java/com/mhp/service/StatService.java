package com.mhp.service;

import com.mhp.result.Result;
import org.springframework.stereotype.Service;
import com.mhp.vo.StatVO;

@Service
public interface StatService {
    /**
     * 统计总览
     * @return
     */
    Result<StatVO> overview();
}
