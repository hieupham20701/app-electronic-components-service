package com.iuh.ecapp.dto.request;

import com.iuh.ecapp.model.enums.UserRole;

import java.util.Date;

public class UserRequest {
    private String userName;

    private String password;

    private String firstName;
    private String lastName;
    private String address;
    private String telephone;

    private Date createdDate;

    private Date modifiedDate;

    private UserRole role;
    private String avatar;
}
