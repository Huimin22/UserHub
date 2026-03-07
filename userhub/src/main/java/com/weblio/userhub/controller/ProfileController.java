package com.weblio.userhub.controller;

import com.weblio.userhub.model.User;
import com.weblio.userhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    // Show current user's profile
    @GetMapping
    public String showProfile(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "profile";  // Thymeleaf template
    }

    // Update profile
    @PostMapping("/update")
    public String updateProfile(@ModelAttribute("user") User user) {
        userService.register(user);  // reuse register to update
        return "redirect:/profile";
    }
}
