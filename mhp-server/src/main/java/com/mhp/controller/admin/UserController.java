package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mhp.dto.UserPageQueryDTO;
import com.mhp.result.PageResult;
import com.mhp.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springdoc.core.annotations.ParameterObject;
import com.mhp.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import com.mhp.entity.SysUser;
import com.mhp.vo.UserVO;
import java.util.List;



@RestController
@RequestMapping("/admin/user")
@Tag(name = "用户管理接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户分页查询
     * @param userPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @Operation(summary = "用户分页查询")
    public Result<PageResult> page(@ParameterObject UserPageQueryDTO userPageQueryDTO) {
        log.info("用户分页查询请求：{}", userPageQueryDTO);
        PageResult pageResult = userService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody SysUser sysUser) {
        //TODO: process POST request
        log.info("新增用户请求：{}", sysUser);
        userService.add(sysUser);
        return Result.success(sysUser);
    }
    /**
     * 修改用户
     * @param userId 用户ID
     * @return
     */
    @PutMapping
    @Operation(summary = "修改用户")
    public Result update(@RequestBody SysUser sysUser) {
        log.info("修改用户请求：{}", sysUser);
        userService.update(sysUser);
        return Result.success(sysUser);
    }
    
    /**
     * 启用/禁用用户
     * @param userId 用户ID
     * @return
     */
    @PostMapping("status/{status}")
    @Operation(summary = "启用/禁用用户")
    public Result updateStatus(@PathVariable Integer status,Long id) {
        log.info("启用/禁用用户请求：{}，用户ID：{}", status, id);
        userService.updateStatus(status, id);
        return Result.success();
    }

    /**获取用户详情
     * @param id 用户ID
     * @return
     */
    @GetMapping("/{id}")
    public Result<UserVO> getDetail(@PathVariable Long id) {
        UserVO userVO = userService.getDetail(id);
        return Result.success(userVO);
    }

    /**
     * 删除用户
     * @param ids 用户ID列表
     * @return
     */
    @DeleteMapping("batch")
    @Operation(summary = "删除用户")
    public Result delete(@RequestParam List<Long> ids) {
        userService.deleteBatch(ids);
        return Result.success();
    }
    
}
