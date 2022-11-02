package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.dto.request.UserRequest;
import com.iuh.ecapp.dto.response.UserResponse;
import com.iuh.ecapp.mapper.MapData;
import com.iuh.ecapp.model.entity.User;
import com.iuh.ecapp.model.enums.UserRole;
import com.iuh.ecapp.repository.UserRepository;
import com.iuh.ecapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthServiceImpl implements AuthService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User getUser(String userName) {
        return userRepository.findUserByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        User user = MapData.mapOne(userRequest, User.class);
        user.setRole(UserRole.USER_ROLE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        return MapData.mapOne(userRepository.save(user), UserResponse.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
