package com.mhp.dto.admin;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserPageQueryDTO implements Serializable {
    private Integer page;
    private Integer pageSize;
    
    private String realName;
    private String studentNo;
    private String status;
}
