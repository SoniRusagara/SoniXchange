package com.soniXchange.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public interface AppConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(management ->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
            .addFilterBefore(new JwtTokenValidator(), BasicAutheticationFilter.class)
            .csrf(csrf->csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))


        return null;
    }

    private CorsConfigurationSource corsConfigurationSource() {
        return null;
    }
    
}
