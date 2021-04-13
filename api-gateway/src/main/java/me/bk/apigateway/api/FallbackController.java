package me.bk.apigateway.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : byungkyu
 * @date : 2021/04/13
 * @description :
 **/
@RestController
public class FallbackController {

	@GetMapping("/fallback/member-service")
	public String memberServiceFallback() {
		return "Member Service is invalid. please try again later";
	}

	@GetMapping("/fallback/chat-service")
	public String chatServiceFallback() {
		return "Member Service is invalid. please try again later";
	}
}
