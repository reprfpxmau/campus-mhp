package com.mhp.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminLoginDTO implements Serializable {
    private String username;
    private String password;
}
