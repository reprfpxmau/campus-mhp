package com.mhp.vo;

import java.util.List;
import lombok.Data;
import java.util.ArrayList;

@Data
public class ScaleVO {
    // 量表ID
    private Long scaleId;
    // 量表名称
    private String scaleName;
    
    // 题目列表
    private List<PsyQuestionVO> questions = new ArrayList<>();
}
