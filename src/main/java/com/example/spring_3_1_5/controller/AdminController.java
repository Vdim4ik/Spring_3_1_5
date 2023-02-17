package com.example.spring_3_1_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

//    @GetMapping("/new")
//    public String getPageToAddNewUser(ModelMap modelMap, Principal principal) {
//        modelMap.addAttribute("user", userService.findByEmail(principal.getName()));
//        modelMap.addAttribute("newUser", new User());
//        modelMap.addAttribute("roleList", roleService.getRoleList());
//        return "new";
//    }
//
//    @PostMapping("/new")
//    public String addNewUser(@ModelAttribute User user) {
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PatchMapping("/update/{email}")
//    public String updateUser(@ModelAttribute User user, @PathVariable("email") String email) {
//        userService.updateUser(email, user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
}
