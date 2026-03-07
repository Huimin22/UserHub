package com.weblio.userhub.controller;

import com.weblio.userhub.model.User;
import com.weblio.userhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // Thymeleaf template name
    }

    // Handle registration submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/login";  // Redirect to login page after registration
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Thymeleaf template name
    }
}
