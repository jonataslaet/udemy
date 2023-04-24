package com.github.jonataslaet.services;

import com.github.jonataslaet.data.vo.v1.security.AccountCredentialsVO;
import com.github.jonataslaet.data.vo.v1.security.TokenVO;
import com.github.jonataslaet.exceptions.InvalidJwtAuthenticationException;
import com.github.jonataslaet.repositories.UserRepository;
import com.github.jonataslaet.security.JwtTokenProvider;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private UserRepository userRepository;

  public ResponseEntity signin(AccountCredentialsVO loginData) {
    try {
      var username = loginData.getUsername();
      var password = loginData.getPassword();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      var user = userRepository.findByUsername(username);
      TokenVO tokenResponse;
      if (Objects.nonNull(user)) {
        tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
      } else {
        throw new UsernameNotFoundException("Username " + username + " not found.");
      }
      return ResponseEntity.ok(tokenResponse);
    } catch (Exception e) {
      throw new InvalidJwtAuthenticationException("Invalid username or password");
    }
  }

  public ResponseEntity refresh(String username, String bearerToken) {
    var user = userRepository.findByUsername(username);
    TokenVO tokenResponse;
    if (Objects.nonNull(user)) {
      tokenResponse = jwtTokenProvider.refreshToken(bearerToken);
    } else {
      throw new UsernameNotFoundException("Username " + username + " not found.");
    }
    return ResponseEntity.ok(tokenResponse);
  }
}
