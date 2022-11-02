package com.iuh.ecapp.dto.request;

import com.iuh.ecapp.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;

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
