package com.example.zerotrust.global.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Slf4j
@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.csrfTokenRepository(csrfTokenRepository())
                .ignoringRequestMatchers("/**")
        );
//        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );
        http.formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/list")
                .failureUrl("/fail")
        );
        http.logout(logout -> logout.logoutUrl("/logout"));

        return http.build();
    }

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
