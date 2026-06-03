package com.mhp.dto.admin;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long appointmentId;
    private Long counselorId;

    private Integer status;
}
