package com.mhp.mapper.user;

import com.mhp.dto.user.ProfileDTO;
import com.mhp.vo.user.ProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfileMapper{
    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    @Select("select * from sys_user_profile where user_id = #{userId}")
    ProfileVO selectById(Long userId);

    /**
     * 更新用户信息
     * @param userId 用户ID
     * @return 更新结果
     */
    void updateById(ProfileDTO profileDTO);  
}
