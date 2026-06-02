package com.mhp.service.impl.user;

import com.mhp.entity.MhArchive;
import com.mhp.vo.user.ArchiveVO;
import com.mhp.service.user.UserArchiveService;
import com.mhp.result.Result;
import org.springframework.stereotype.Service;
import com.mhp.mapper.user.UserArchiveMapper;
import com.mhp.context.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserArchiveServiceImpl implements UserArchiveService {
    @Autowired
    private UserArchiveMapper userArchiveMapper;

    /**
     * 查询用户档案
     * @return
     */
    @Override
    public Result<ArchiveVO> getMyArchive() {
        Long studentId = BaseContext.getCurrentId();
        ArchiveVO archiveVO = userArchiveMapper.getMyArchive(studentId);
        return Result.success(archiveVO);
    }

    /**
     * 完成用户档案
     * @param mhArchive 用户档案
     */
    @Override
    public void completeMyArchive(MhArchive mhArchive) {
        Long studentId = BaseContext.getCurrentId();
        mhArchive.setStudentId(studentId);
        mhArchive.setUpdateTime(LocalDateTime.now());
        log.info("用户补全档案{}", mhArchive);
        userArchiveMapper.updateById(mhArchive);
    }
}
