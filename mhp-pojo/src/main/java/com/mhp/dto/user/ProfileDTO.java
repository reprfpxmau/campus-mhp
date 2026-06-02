package com.mhp.dto.user;

import lombok.Data;

@Data
public class ProfileDTO {
    private Long userId;
    private String avatar;
    private String emergencyContact;
    private String emergencyPhone;
    private String bio;
}
