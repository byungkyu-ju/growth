package me.bk.memberservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : byungkyu
 * @date : 2021/04/13
 * @description :
 **/
@Configuration
public class ExternalTransactionConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
