package com.mhp.vo.user;

import lombok.Data;
import java.util.List;

@Data
public class ScaleVO {
    
    private String scaleName;
    private List<QuestionsVO> questions;
}
