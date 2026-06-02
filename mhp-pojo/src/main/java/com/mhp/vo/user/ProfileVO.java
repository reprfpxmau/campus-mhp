package com.mhp.vo.user;

import lombok.Data;

@Data
public class ProfileVO {
    private Integer profileId;
    private String avatar;
    private String emergencyContact;
    private String emergencyPhone;
    private String bio;
}
