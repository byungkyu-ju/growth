package me.bk.apigateway.auth.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import me.bk.apigateway.auth.dto.MemberLoginResponse;
import me.bk.apigateway.auth.dto.TokenRequest;
import me.bk.apigateway.auth.dto.TokenResponse;
import me.bk.apigateway.auth.infrastructure.JwtTokenProvider;
import me.bk.apigateway.auth.infrastructure.TokenType;
import reactor.core.publisher.Mono;

/**
 * @author : byungkyu
 * @date : 2021/04/26
 * @description :
 **/
@Service
@RequiredArgsConstructor
public class AuthService {

	private static final String MEMBER_SERVICE_URL = "http://localhost:30000";
	private final JwtTokenProvider jwtTokenProvider;

	public Mono<TokenResponse> login(TokenRequest request) {

		WebClient webClient = WebClient.create(MEMBER_SERVICE_URL);

		Mono<MemberLoginResponse> memberLoginResponseMono = webClient.get()
			.uri("/members/{email}", request.getEmail()).accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError,
				clientResponse -> Mono.error(new IllegalArgumentException("등록되지 않은 사용자")))
			.bodyToMono(MemberLoginResponse.class);

		Mono<TokenResponse> tokenResponseMono = memberLoginResponseMono.map(memberLoginResponse -> {
			checkPassword(request.getPassword(), memberLoginResponse.getPassword());
			String accessToken = jwtTokenProvider.createToken(TokenType.ACCESS_TOKEN, memberLoginResponse.getEmail());
			String refreshToken = jwtTokenProvider.createToken(TokenType.REFRESH_TOKEN, memberLoginResponse.getEmail());

			return new TokenResponse(accessToken, refreshToken);
		});

		return tokenResponseMono;
	}

	private void checkPassword(String requestPassword, String memberPassword) {
		if(!requestPassword.equals(memberPassword)){
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
	}
}
