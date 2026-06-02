package com.mhp.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.mhp.entity.MhArchive;
import com.mhp.vo.user.ArchiveVO;
import com.mhp.service.user.UserArchiveService;
import com.mhp.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user/archive")
@Tag(name = "用户档案相关接口")
@Slf4j
public class UserArchiveController {
    @Autowired
    private UserArchiveService userArchiveService;
    
    @GetMapping("my")
    public Result<ArchiveVO> getMyArchive() {
        log.info("查询用户档案");
        Result<ArchiveVO> archiveVO = userArchiveService.getMyArchive();
        return archiveVO;
    }

    /**
     * 完成用户档案
     * @param archiveVO 用户档案
     * @return
     */
    @PutMapping("complete")
    public Result completeMyArchive(@RequestBody MhArchive mhArchive) {
        log.info("用户补全档案{}", mhArchive);
        userArchiveService.completeMyArchive(mhArchive);
        return Result.success();
    }
}
