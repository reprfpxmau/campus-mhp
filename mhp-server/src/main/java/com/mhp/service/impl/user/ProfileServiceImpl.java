package com.mhp.service.impl.user;

import org.springframework.stereotype.Service;
import com.mhp.dto.user.ProfileDTO;
import com.mhp.vo.user.ProfileVO;
import com.mhp.mapper.user.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.context.BaseContext;
import com.mhp.service.user.ProfileService;
import lombok.extern.slf4j.Slf4j;
import com.mhp.result.Result;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileMapper profileMapper;
    
    /**
     * 查询用户个人信息
     * @return
     */
    @Override
    public Result<ProfileVO> myInfo() {
        Long userId = BaseContext.getCurrentId();
        log.info("当前用户ID：{}", userId);
        ProfileVO profileVO = profileMapper.selectById(userId);
        return Result.success(profileVO);
    }

    /**
     * 更新用户个人信息
     * @return
     */
    @Override
    public Result<ProfileVO> updateMyInfo(ProfileDTO profileDTO) {
        Long userId = BaseContext.getCurrentId();
        profileDTO.setUserId(userId);
        profileMapper.updateById(profileDTO);
        return Result.success();
    }
}
