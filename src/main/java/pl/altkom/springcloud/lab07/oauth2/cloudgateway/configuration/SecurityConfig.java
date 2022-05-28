package pl.altkom.springcloud.lab07.oauth2.cloudgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http) {
        http.authorizeExchange().pathMatchers("/actuator/**").permitAll()
                .and().authorizeExchange().anyExchange().authenticated()
                .and().oauth2Login();
        http.csrf().disable();
        return http.build();
    }
}
