package com.mhp.dto.admin;

import java.io.Serializable;
import lombok.Data;

@Data
public class ScalePageQueryDTO implements Serializable {
    private Integer page;
    private Integer pageSize;

    // 心理量表名称
    private String scaleName;
    // 状态：0=停用 1=启用
    private String status;
}
