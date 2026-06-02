package com.mhp.vo.user;

import lombok.Data;

@Data
public class ArchiveVO {
    private Integer archiveId;
    private String studentNo;
    private String name;
    private Integer gender;
    private String collegeName;
    private String className;
    private Integer archiveStatus;
    private Integer riskLevel;
    private String familyStructure;
    private String medicalHistory;
    private String majorEvents;

    
    private Integer classId;
    private Integer collegeId;
}
