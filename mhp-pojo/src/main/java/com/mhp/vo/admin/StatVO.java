package com.mhp.vo.admin;

import lombok.Data;

@Data
public class StatVO {
    private Long totalStudents;
    private Long totalExams;
    private Long todayAppointments;
    private Long pendingWarnings;
}
