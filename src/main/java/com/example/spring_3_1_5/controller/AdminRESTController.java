package com.example.spring_3_1_5.controller;

import com.example.spring_3_1_5.model.User;
import com.example.spring_3_1_5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class AdminRESTController {

    private final UserService userService;

    @Autowired
    public AdminRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserTable() {
        List<User> users = userService.getUserList();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/new")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User user){
        userService.updateUser(email, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
