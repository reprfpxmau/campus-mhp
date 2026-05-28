package com.mhp.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminLoginLogDTO implements Serializable {
    private Integer page;
    private Integer pageSize;

    // 0 成功 1 失败
    private Integer loginStatus;
}
