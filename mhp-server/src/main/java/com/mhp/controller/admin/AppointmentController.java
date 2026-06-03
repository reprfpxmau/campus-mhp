package com.mhp.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import com.mhp.result.Result;
import com.mhp.service.admin.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springdoc.core.annotations.ParameterObject;
import com.mhp.dto.admin.AppointmentPageQueryDTO;
import com.mhp.result.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mhp.dto.admin.AppointmentDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.mhp.vo.admin.completedStudentsVO;

@RestController
@RequestMapping("/admin/appointment")
@Tag(name = "预约相关接口")
@Slf4j
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 分页查询预约
     * @param appointmentPageQueryDTO
     * @return
     */
    @GetMapping("page")
    public Result<PageResult> page(@ParameterObject AppointmentPageQueryDTO appointmentPageQueryDTO) {
        log.info("分页查询预约请求：{}", appointmentPageQueryDTO);
        PageResult pageResult = appointmentService.pageQuery(appointmentPageQueryDTO);
        return Result.success(pageResult);
    }
    
    /* 改派咨询师 */
    @PutMapping
    public Result<Void> reassign(@RequestBody AppointmentDTO appointmentDTO) {
        log.info("改派咨询师请求：{}", appointmentDTO);
        appointmentService.reassign(appointmentDTO);
        return Result.success();
    }

    /**
     * 确认预约
     * @param id
     * @return
     */
    @PostMapping("confirm/{id}")
    public Result<Void> confirm(@PathVariable Long id) {
        log.info("确认预约请求：{}", id);
        appointmentService.confirm(id);
        return Result.success();
    }

    /**
     * 更新预约状态
     * @param id
     * @param status
     * @return
     */
    @PostMapping("reject/{id}")
    public Result<Void> reject(@PathVariable Long id) {
        log.info("拒绝预约请求：{}", id);
        appointmentService.reject(id);
        return Result.success();
    }

    /**
     * 取消预约
     * @param id
     * @return
     */
    @PostMapping("cancel/{id}")
    public Result<Void> cancel(@PathVariable Long id) {
        log.info("取消预约请求：{}", id);
        appointmentService.cancel(id);
        return Result.success();
    }

    /**
     * 查询已完成预约的学生
     * 无 （咨询师登录后自动筛选自己的预约）
     * @return
     */
    @GetMapping("completed-students")
    public Result<List<completedStudentsVO>> completedStudents() {
        log.info("查询已完成预约的学生请求");
        List<completedStudentsVO> completedStudents = appointmentService.completedStudents();
        return Result.success(completedStudents);
    }

    
}
