package com.mhp.vo;

import java.util.List;

import com.mhp.entity.PsyOption;
import lombok.Data;

@Data
public class PsyQuestionVO {
     // 主键
    private Long questionId;
    // 量表ID
    private Long scaleId;
    // 题号
    private Integer questionNo;
    // 题目内容
    private String content;
    // 是否反向计分:0=否 1=是
    private Integer isReverse;
    // 所属维度
    private String dimension;

    // 扩展:选项列表
    private List<PsyOption> optionList;
}
