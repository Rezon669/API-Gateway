//package com.ecom.apigatewayservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
//
//    @SuppressWarnings("deprecation")
//	@Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        logger.info("Configuring SecurityFilterChain...");
//
//        http
//                .csrf(csrf -> csrf.disable())  // Disable CSRF protection
//                .authorizeRequests(requests -> requests
//                        .requestMatchers("/public/**", "/easybuy/user/authenticate", "/easybuy/user/createaccount", "/easybuy/user/updatepassword").permitAll()  // Public paths
//                        .anyRequest().authenticated())
//                .httpBasic(basic -> basic.disable());  // Enable basic HTTP authentication
//
//        logger.info("SecurityFilterChain configured successfully");
//
//        return http.build();
//    }
//}
