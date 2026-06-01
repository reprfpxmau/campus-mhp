package com.mhp.service.admin;

import org.springframework.stereotype.Service;

import com.mhp.vo.admin.CounselorPageQueryVO;

import java.util.List;

/**
 * 咨询师服务接口
 */
@Service
public interface CounselorService {
    /**
     * 分页查询咨询师
     * @return 分页结果
     */
    List<CounselorPageQueryVO> list();
}
