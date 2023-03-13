package com.github.jonataslaet.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.ClaimsHolder;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.jonataslaet.data.vo.v1.security.TokenVO;
import com.github.jonataslaet.exceptions.InvalidJwtAuthenticationException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class JwtTokenProvider {

  @Value("${security.jwt.token.secret-key}")
  private String secretKey = "secret";

  @Value("${security.jwt.token.expire-length}")
  private Long validityInMilliseconds = 3600000L;

  @Autowired
  private UserDetailsService userDetailsService;


  Algorithm algorithm = null;

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    algorithm = Algorithm.HMAC256(secretKey.getBytes());
  }

  public TokenVO createAccessToken(String username, List<String> roles) {
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    var accessToken = getAccessToken(username, roles, now, validity);
    var refreshToken = getRefreshToken(username, roles, now);
    return new TokenVO(username, true, now, validity, accessToken, refreshToken);
  }

  public TokenVO refreshToken(String bearerToken) {
    if (bearerToken.contains("Bearer ")) {
      bearerToken = StringUtils.substringAfter(bearerToken, "Bearer ");
    }
    DecodedJWT decodedJWT = decodedToken(bearerToken);
    return createAccessToken(decodedJWT.getSubject(), decodedJWT.getClaim("roles").asList(String.class));
  }

  private String getRefreshToken(String username, List<String> roles, Date now) {
    Date validityRefreshToken = new Date(now.getTime() + validityInMilliseconds * 3);;
    return JWT.create()
        .withClaim("roles", roles)
        .withIssuedAt(now).withExpiresAt(validityRefreshToken)
        .withSubject(username).sign(algorithm).strip();
  }

  private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
    String issuerUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    return JWT.create()
        .withClaim("roles", roles)
        .withIssuedAt(now).withExpiresAt(validity)
        .withSubject(username).withIssuer(issuerUrl).sign(algorithm).strip();
  }

  public Authentication getAuthentication(String token) {
    DecodedJWT decodedJWT = decodedToken(token);
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  private DecodedJWT decodedToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
    DecodedJWT decodedJWT = jwtVerifier.verify(token);
    return decodedJWT;
  }

  public String getTokenFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.isNotBlank(bearerToken) && StringUtils.startsWith(bearerToken, "Bearer ")) {
      return StringUtils.substringAfter(bearerToken, "Bearer ");
    }
    return null;
  }

  public boolean isValidToken(String token) {
    try {
      return isTokenWithValidDate(token);
    } catch (Exception exception) {
      throw new InvalidJwtAuthenticationException("Expired or invalid JWT Token");
    }
  }

  private boolean isTokenWithValidDate(String token) {
    DecodedJWT decodedJWT = decodedToken(token);
    return !decodedJWT.getExpiresAt().before(new Date());
  }

}
