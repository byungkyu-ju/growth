package me.bk.apigateway.auth.infrastructure;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author : byungkyu
 * @date : 2021/04/27
 * @description :
 **/

@Component
public class JwtTokenProvider {
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;

	public String createToken(TokenType tokenType, String payload) {
		Claims claims = Jwts.claims().setSubject(payload);
		Date now = new Date();

		Date validity = new Date(now.getTime() + tokenType.getExpireTime());

		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(validity)
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}

	public String getPayload(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return !claims.getBody().getExpiration().before(new Date());
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}

