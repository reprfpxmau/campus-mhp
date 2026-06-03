package com.mhp.dto.admin;

import lombok.Data;

@Data
public class ConsultRecordDTO {
    
    private Long studentId;
    private String chiefComplaint;
    private String consultProcess;
    private String assessment;
    private String suggestion;

    private Long appointmentId;
    private String studentName;
    private Long sessionId;
}