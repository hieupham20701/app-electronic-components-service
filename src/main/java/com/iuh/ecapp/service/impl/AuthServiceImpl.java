package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.dto.request.UserRequest;
import com.iuh.ecapp.dto.response.UserResponse;
import com.iuh.ecapp.mapper.MapData;
import com.iuh.ecapp.model.entity.User;
import com.iuh.ecapp.model.enums.UserRole;
import com.iuh.ecapp.repository.UserRepository;
import com.iuh.ecapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User getUser(String userName) {
        return userRepository.findUserByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        User user = MapData.mapOne(userRequest, User.class);
        user.setRole(UserRole.USER_ROLE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        return MapData.mapOne(userRepository.save(user), UserResponse.class);
    }
}
