package com.example.springsecuritysample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecuritySampleConfig {
//    SpringSecuritySampleDetailsService springSecuritySampleDetailsService;

    @Bean
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
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails userDetails = User
//                .withUsername("user2")
//                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    public AuthenticationManager authConfig(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("AuthenticationManagerBuilder");
//
//        return auth.userDetailsService(springSecuritySampleDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new SpringSecuritySampleDetailsService();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
