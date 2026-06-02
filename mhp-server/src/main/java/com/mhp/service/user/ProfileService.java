package com.mhp.service.user;

import org.springframework.stereotype.Service;
import com.mhp.dto.user.ProfileDTO;
import com.mhp.vo.user.ProfileVO;
import com.mhp.result.Result;


@Service
public interface ProfileService {
    /**
     * 查询用户个人信息
     * @return
     */
    Result<ProfileVO> myInfo();
    /**
     * 更新用户个人信息
     * @return
     */
    Result<ProfileVO> updateMyInfo(ProfileDTO profileDTO);
}