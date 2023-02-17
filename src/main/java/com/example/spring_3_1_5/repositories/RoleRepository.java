package com.example.spring_3_1_5.repositories;

import com.example.spring_3_1_5.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { }