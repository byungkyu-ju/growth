package me.bk.apigateway.auth.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bk.apigateway.auth.application.AuthService;
import me.bk.apigateway.auth.dto.TokenRequest;
import me.bk.apigateway.auth.dto.TokenResponse;
import reactor.core.publisher.Mono;

/**
 * @author : byungkyu
 * @date : 2021/04/26
 * @description :
 **/

@RestController
public class AuthController {
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/login/token")
	public ResponseEntity<Mono<TokenResponse>> login(@RequestBody TokenRequest request) {
		Mono<TokenResponse> token = authService.login(request);
		return ResponseEntity.ok().body(token);
	}
}