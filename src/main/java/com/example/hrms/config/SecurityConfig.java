package com.example.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
   @Bean
    public BCryptPasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
       UserDetails user1 = User.builder()
               .username("seda")
               .password(passwordEncoder().encode("abcd"))
               .roles("USER")
               .build();
       UserDetails admin = User.builder()
               .username("sedaye")
               .password(passwordEncoder().encode("12345"))
               .roles("ADMIN")
               .build();
    return new InMemoryUserDetailsManager(user1, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(x -> x.anyRequest().authenticated())
               .httpBasic(Customizer.withDefaults());
       return http.build();
    }
}


