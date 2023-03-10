package com.example.springsecuritysample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringSecuritySampleDetailsService implements UserDetailsService {

    SpringSecuritySampleRepository repository;
//
//    @Autowired
//    public SpringSecuritySampleDetailsService(SpringSecuritySampleRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);

        SpringSecuritySampleUser user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("empty");
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(authority);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return new User(user.getUsername(), encoder.encode(user.getPassword()), grantedAuthorities);
        }
    }
}
