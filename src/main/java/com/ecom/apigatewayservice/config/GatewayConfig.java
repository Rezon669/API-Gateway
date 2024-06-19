package com.ecom.apigatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GatewayConfig {



	    @Bean
	    public RestTemplate template(){
	       return new RestTemplate();
	    }
	    
	    @Bean
	    public WebClient.Builder webClientBuilder() {
	        return WebClient.builder();
	    }
	    
	    @Bean
	    public org.springframework.web.client.RestClient.Builder restClientBuilder() {
	        return org.springframework.web.client.RestClient.builder();
	    }
}

