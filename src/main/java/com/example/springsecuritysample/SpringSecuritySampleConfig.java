package com.example.springsecuritysample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecuritySampleConfig {
    @Autowired
    SpringSecuritySampleDetailsService springSecuritySampleDetailsService;

//    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .anyRequest().authenticated()
        );
        http.csrf().disable();
        //h2consoleを使用可能（SpringSecurityを入れている場合consoleで接続を拒否される）
        http.headers().frameOptions().disable();
        return http.build();
    }

//    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User
                .withUsername("user2")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Autowired
    public void userDetailsManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(springSecuritySampleDetailsService).passwordEncoder(passwordEncoder());
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
