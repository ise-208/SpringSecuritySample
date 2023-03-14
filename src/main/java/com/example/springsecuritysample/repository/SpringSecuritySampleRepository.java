package com.example.springsecuritysample.repository;

import com.example.springsecuritysample.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSecuritySampleRepository extends JpaRepository<Demo, String> {
//public class SpringSecuritySampleRepository {

    //    @Query("SELECT u FROM User u WHERE u.username = :username")
    Demo findByUsername(String username);

//    public User findByUsername(String username){
//        return new User("id", "user3", "password", "user");
//    }
//

}
