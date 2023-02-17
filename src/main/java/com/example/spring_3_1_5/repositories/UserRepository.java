package com.example.spring_3_1_5.repositories;

import com.example.spring_3_1_5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles where u.email= :email")
    User findByEmail(String email);

}
