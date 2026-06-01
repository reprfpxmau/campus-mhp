package com.mhp.vo.admin;

import lombok.Data;

@Data
public class ExamReportVO {
    private Long studentId;
    private Long scaleId;
    
    private Double totalScore;
    private Integer resultLevel;
    private String dimensionScores;
    private String interpretation;
    private String suggestions;
    private String generateTime;

    private String studentName;
    private String scaleName;

}
