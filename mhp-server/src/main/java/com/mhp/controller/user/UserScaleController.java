package com.mhp.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;  
import com.mhp.result.Result;
import com.mhp.entity.PsyScale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.mhp.service.user.UserScaleService;
import java.util.List;
import com.mhp.vo.user.QuestionsVO;
import com.mhp.vo.user.ScaleVO;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user/scale")
@Tag(name = "用户测试相关接口")
@Slf4j
public class UserScaleController {
    @Autowired
    private UserScaleService userScaleService;
    
    /**
     * 查询用户测试可用的测试项
     * @return 可用的测试项
     */
    @GetMapping("/available")
    public Result<List<PsyScale>> available() {
        Result<List<PsyScale>> psyScale = userScaleService.scaleList();
        return psyScale;
    }

    /**
     * 用户测试题目
     * @return 测试题目
     */
   // @Cacheable(cacheNames = "scaleCache", key = "#scaleId")
    @GetMapping("/{scaleId}/questions")
    public Result<List<QuestionsVO>> scale(@PathVariable Integer scaleId) {
    
        ScaleVO scaleVO = userScaleService.scale(scaleId);
        return Result.success(scaleVO.getQuestions());
    }
}
