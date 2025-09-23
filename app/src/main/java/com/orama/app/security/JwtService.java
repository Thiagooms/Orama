package com.orama.app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.orama.app.model.Client;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  @Value("${api.security.token.secret}")
  private String secret;

  @Value("${api.security.token.expirationMinutes:30}")
  private Long expirationMinutes;

  private Algorithm getAlgorithm() {
    return Algorithm.HMAC256(secret);
  }

  public String generateToken(Client client) {
    return JWT.create()
            .withSubject(client.getId().toString())
            .withClaim("role", client.getRole().name())
            .withIssuedAt(new Date())
            .withExpiresAt(Date.from(generateExpirationDate()))
            .sign(getAlgorithm());
  }

  public boolean isTokenValid(String token) {
    try {
      getDecodedJWT(token);
      return true;
    } catch (JWTVerificationException e) {
      return false;
    }
  }

  public Long getClientIdFromToken(String token) {
    return Long.parseLong(getDecodedJWT(token).getSubject());
  }

  public String getClientRoleFromToken(String token) {
    return getDecodedJWT(token).getClaim("role").asString();
  }

  private DecodedJWT getDecodedJWT(String token) throws JWTVerificationException {
    return JWT.require(getAlgorithm()).build().verify(token);
  }

  public Instant generateExpirationDate() {
    return LocalDateTime.now().plusMinutes(expirationMinutes).toInstant(ZoneOffset.of("-03:00"));
  }
}