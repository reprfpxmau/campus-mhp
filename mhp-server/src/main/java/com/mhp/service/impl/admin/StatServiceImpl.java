package com.mhp.service.impl.admin;

import org.springframework.stereotype.Service;
import com.mhp.result.Result;
import com.mhp.service.admin.StatService;
import com.mhp.vo.admin.StatVO;



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
