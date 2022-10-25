package com.iuh.ecapp.service;

import com.iuh.ecapp.dto.request.UserRequest;
import com.iuh.ecapp.dto.response.UserResponse;
import com.iuh.ecapp.model.entity.User;

public interface AuthService {
    User getUser(String userName);
    UserResponse register(UserRequest userRequest);
}
