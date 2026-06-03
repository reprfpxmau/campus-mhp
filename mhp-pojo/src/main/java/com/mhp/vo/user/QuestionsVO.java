package com.mhp.vo.user;

import lombok.Data;
import java.util.List;

@Data
public class QuestionsVO {
    private Long questionId;
    private Integer questionNo;
    private String content;
    private List<OptionVO> options;
}
