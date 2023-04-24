package com.github.jonataslaet.controllers;

import com.github.jonataslaet.data.vo.v1.security.AccountCredentialsVO;
import com.github.jonataslaet.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@Tag(name = "Authentication Endpoint")
public class AuthController {

  @Autowired
  AuthService authService;

  @Operation(summary = "Authenticates a user and returns a token")
  @PostMapping(value = "/signin")
  public ResponseEntity<?> signin(@RequestBody AccountCredentialsVO loginData) {
    if (Objects.isNull(loginData) || Objects.isNull(loginData.getUsername()) || Objects.isNull(loginData.getPassword())) {
      return forbidden();
    }
    var token = authService.signin(loginData);
    if (Objects.isNull(token)) {
      return forbidden();
    }
    return token;
  }

  @Operation(summary = "Refresh and return a token for authenticated user")
  @PutMapping(value = "/refresh/{username}")
  public ResponseEntity<?> refresh(@PathVariable("username") String username, @RequestHeader("Authorization")
      String bearerToken) {
    if (Objects.isNull(bearerToken) || StringUtils.isBlank(bearerToken)) {
      return forbidden();
    }
    var token = authService.refresh(username, bearerToken);
    if (Objects.isNull(token)) {
      return forbidden();
    }
    return token;
  }

  private ResponseEntity<?> forbidden() {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid data");
  }
}
