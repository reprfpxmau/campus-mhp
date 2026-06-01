package com.mhp.entity;

import lombok.Data;
import java.util.List;

@Data
public class PsyQuestionDTO {
    private Long scaleId;
    private String questionNo;
    private String content;
    private String isReverse;
    private String dimension;

    // 题目ID
    private Long questionId;
    // 选项列表
    private List<PsyOption> options;
}
