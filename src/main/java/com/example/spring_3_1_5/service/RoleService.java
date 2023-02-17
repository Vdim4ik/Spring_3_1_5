package com.example.spring_3_1_5.service;

import com.example.spring_3_1_5.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoleList();

    void addRole(Role role);

}
