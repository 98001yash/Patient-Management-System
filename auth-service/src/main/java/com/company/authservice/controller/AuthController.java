package com.company.authservice.controller;


import com.company.authservice.dto.LoginRequestDto;
import com.company.authservice.dto.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    @Operation(summary = "Generate token on user Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto loginRequestDto){

        Optional<String> tokenOptional = authService.authenticate(loginRequestDto);

    }
}
