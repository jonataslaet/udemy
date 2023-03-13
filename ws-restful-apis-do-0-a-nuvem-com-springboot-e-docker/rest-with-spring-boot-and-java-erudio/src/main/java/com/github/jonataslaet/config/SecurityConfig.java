package com.github.jonataslaet.config;

import com.github.jonataslaet.security.JwtConfigurer;
import com.github.jonataslaet.security.JwtTokenProvider;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  AuthenticationManager authenticationManagerBean(
      AuthenticationConfiguration authenticationConfiguration) throws Exception{
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtTokenProvider jwtTokenProvider) throws Exception {
    return httpSecurity
        .httpBasic().disable()
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(
                    "/auth/signin",
                    "/auth/refresh/**",
                    "/auth/**",
                    "/api-docs/**",
                    "/swagger-ui.html**",
                    "/swagger-ui/**"
                ).permitAll()
                .requestMatchers("/**").authenticated()
                .requestMatchers("/users").denyAll()
        )
        .cors().and()
        .apply(new JwtConfigurer(jwtTokenProvider))
        .and()
        .build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    Map<String, PasswordEncoder> passwordEncoderMap = new HashMap<>();
    Pbkdf2PasswordEncoder pbkdf2PasswordEncoder =
        new Pbkdf2PasswordEncoder("", 8, 185000,
            Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    passwordEncoderMap.put("pbkdf2", pbkdf2PasswordEncoder);
    DelegatingPasswordEncoder delegatingPasswordEncoder =
        new DelegatingPasswordEncoder("pbkdf2", passwordEncoderMap);
    delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2PasswordEncoder);
    return delegatingPasswordEncoder;
  }
}
