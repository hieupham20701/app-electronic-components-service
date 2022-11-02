package com.iuh.ecapp.dto.response;

import com.iuh.ecapp.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String username;


    private String firstName;
    private String lastName;
    private String address;
    private String telephone;

    private Date createdDate;

    private Date modifiedDate;

    private UserRole role;
    private String avatar;
}
