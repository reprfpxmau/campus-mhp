package com.mhp.mapper.user;

import com.mhp.entity.MhArchive;
import com.mhp.vo.user.ArchiveVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserArchiveMapper {
    /**
     * 查询用户档案
     * @param userId 用户ID
     * @return 用户档案
     */
    ArchiveVO getMyArchive(Long userId);

    /**
     * 更新用户档案
     * @param mhArchive 用户档案
     */
    void updateById(MhArchive mhArchive);
}
