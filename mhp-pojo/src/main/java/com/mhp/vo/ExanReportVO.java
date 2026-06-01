package com.mhp.vo;

import lombok.Data;

@Data
public class ExanReportVO {
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
