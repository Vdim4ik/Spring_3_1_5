package com.example.spring_3_1_5.util;

import com.example.spring_3_1_5.model.Role;
import com.example.spring_3_1_5.model.User;
import com.example.spring_3_1_5.service.RoleService;
import com.example.spring_3_1_5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public Init(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    private void postConstruct() {
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        roleService.addRole(userRole);
        roleService.addRole(adminRole);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(userRole);
        adminRoles.add(adminRole);
        User admin = new User("admin@mail.ru", "admin", "admin", "admin", (byte) 22, adminRoles);

        Set<Role> anotherAdminRole = new HashSet<>();
        anotherAdminRole.add(adminRole);
        User anotherAdmin = new User("vadim@mail.ru", "vadim", "vadim", "vadim", (byte) 22, anotherAdminRole);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        User user = new User("user@mail.ru", "user", "user", "user", (byte) 22, userRoles);

        userService.addUser(admin);
        userService.addUser(anotherAdmin);
        userService.addUser(user);
    }

}
