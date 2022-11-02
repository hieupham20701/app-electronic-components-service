package com.iuh.ecapp.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iuh.ecapp.dto.request.UserRequest;
import com.iuh.ecapp.exceptions.ForbiddenException;
import com.iuh.ecapp.model.entity.User;
import com.iuh.ecapp.service.AuthService;
import com.iuh.ecapp.utils.JWTTokenCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    @PostMapping(value = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/register").toUriString());
        try {
            return ResponseEntity.created(uri).body(authService.register(userRequest));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error_message",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    @CrossOrigin("http://127.0.0.1:5173")
    @PostMapping(value = "/refresh_token", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    public void refreshToken(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String, Object> body) throws IOException {
        String refreshTokenFromRequest = body.get("refreshToken").toString();

        if (refreshTokenFromRequest == null)
            throw new ForbiddenException("Can not get your refresh Token");

        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(refreshTokenFromRequest);

        Integer userId = decodedJWT.getClaim("userId").asInt();

        User existingUser = authService.getUserById(userId);



        JWTTokenCreator tokenCreator = new JWTTokenCreator(existingUser);
        String newAccessToken = tokenCreator.createToken(JWTTokenCreator.TokenType.ACCESS_TOKEN);

        Map<String, Object> tokens = new HashMap<>();
        tokens.put("user", existingUser);
        tokens.put("accessToken", newAccessToken);
        response.setContentType(APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getOutputStream(),tokens);
    }
}
