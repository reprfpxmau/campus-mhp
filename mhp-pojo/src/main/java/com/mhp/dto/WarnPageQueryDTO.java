package com.mhp.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class WarnPageQueryDTO implements Serializable {
    private Integer page;
    private Integer pageSize;
    
    private String studentName;
    private String eventLevel;
    private String eventStatus;
}
