package com.milvus.vector_spring.auth;

import com.milvus.vector_spring.auth.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public void login(@Validated @RequestBody UserLoginRequestDto userLoginRequestDto) {
        authService.login(userLoginRequestDto);
    }
}