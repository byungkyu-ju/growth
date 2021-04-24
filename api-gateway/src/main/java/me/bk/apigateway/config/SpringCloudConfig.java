package me.bk.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author : byungkyu
 * @date : 2021/04/20
 * @description :
 **/
@Configuration
public class SpringCloudConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
			.route("MEMBER-SERVICE", r -> r.path("/member/**")
				.uri("lb://MEMBER-SERVICE")
				)
			.build();
	}

}
