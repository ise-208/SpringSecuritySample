package com.example.springsecuritysample;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSecuritySampleRepository extends JpaRepository<SpringSecuritySampleUser, String> {
    SpringSecuritySampleUser findByUsername(String username);

}
