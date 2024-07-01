package com.ecom.apigatewayservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "JWT-Service", url = "${jwt.service.url}")// Name of the JWT service
public interface JwtService {
//  @PostMapping("/api/tokens") // Path to the token generation endpoint in JWT service
//  String generateToken(@RequestParam("email") String email, 
//                       @RequestParam("role") String role) throws Exception;
  
  
@GetMapping("/api/token/validate")
String validateToken(@RequestParam("token") String token);

}

