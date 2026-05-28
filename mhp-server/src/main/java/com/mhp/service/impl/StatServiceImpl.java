package com.mhp.service.impl;

import org.springframework.stereotype.Service;
import com.mhp.result.Result;
import com.mhp.vo.StatVO;
import com.mhp.service.StatService;



@Service
public class StatServiceImpl implements StatService {

    /**
     * 统计总览
     * @return
     */
    @Override
    public Result<StatVO> overview() {
        StatVO statVO = new StatVO();
        
       return Result.success(statVO);
    }
    
}
