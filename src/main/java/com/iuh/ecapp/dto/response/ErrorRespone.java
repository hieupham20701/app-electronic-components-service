package com.iuh.ecapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorRespone {
    private Date timeStamp;

    private String message;

    private String error;
}
