package com.ecom.apigatewayservice.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ecom.apigatewayservice.feignclient.JwtServiceFeignClient;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	// @Autowired
	// private RouteValidator validator;

	// @Autowired

	// @Autowired
	// JwtService jwtService;

	private final RouteValidator validator;
	// private final JwtUtil jwtUtil;

	@Autowired
	@Lazy
	JwtServiceFeignClient jwtService;

	public AuthenticationFilter(RouteValidator validator, @Lazy JwtServiceFeignClient jwtService) {
		super(Config.class);
		this.validator = validator;
		// this.jwtUtil = jwtUtil;
		this.jwtService = jwtService;
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			if (validator.isSecured.test(exchange.getRequest())) {
				// header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (token != null && token.startsWith("Bearer ")) {
					token = token.substring(7);
					System.out.println(token);
				}
				try {

					String email = jwtService.validateToken(token);

					exchange.getRequest().mutate().header("email", email).build();

				} catch (Exception e) {

					throw new RuntimeException("un authorized access to application");
				}
			}
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}
}