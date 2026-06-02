package com.mhp.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.service.user.ProfileService;
import com.mhp.dto.user.ProfileDTO;
import com.mhp.vo.user.ProfileVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import com.mhp.result.Result;

@RestController
@RequestMapping("/user/profile")
@Tag(name = "个人中心相关接口")
@Slf4j
public class ProfileController{
    @Autowired
    private ProfileService profileService;

    @GetMapping("/my")
    public Result<ProfileVO> myInfo(){
        log.info("查询用户个人信息");
        Result<ProfileVO> profileVO = profileService.myInfo();
        return profileVO;
    }
    
    @PutMapping
    public Result<ProfileVO> updateMyInfo(@RequestBody ProfileDTO profileDTO){
        log.info("更新用户个人信息");
        Result<ProfileVO> profileVO = profileService.updateMyInfo(profileDTO);
        return profileVO;
    }
}
