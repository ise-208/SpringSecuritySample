package com.example.springsecuritysample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SpringSecuritySampleUser {
    private String username;
    private String password;
    private String role;

}
