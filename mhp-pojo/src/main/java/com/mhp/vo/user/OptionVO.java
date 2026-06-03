package com.mhp.vo.user;

import lombok.Data;

@Data
public class OptionVO {
    private Long optionId;
    private String optionNo;
    private String optionText;

    private Long questionId;
}
