package com.mhp.service.user;

import com.mhp.entity.MhArchive;
import com.mhp.vo.user.ArchiveVO;
import org.springframework.stereotype.Service;
import com.mhp.result.Result;

@Service
public interface UserArchiveService {
    /**
     * 查询用户档案
     * @return 用户档案
     */
    Result<ArchiveVO> getMyArchive();

    /**
     * 完成用户档案
     * @param mhArchive 用户档案
     */
    void completeMyArchive(MhArchive mhArchive);
}
