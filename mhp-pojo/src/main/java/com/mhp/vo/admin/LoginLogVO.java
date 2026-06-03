package com.mhp.vo.admin;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LoginLogVO {
    private Long logId;
    private Long userId;
    private String userName;
    private Integer loginType;
    private String ipAddress;
    private String userAgent;
    private Integer loginStatus;
    private LocalDateTime loginTime;
}
