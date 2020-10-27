package ru.itis.resumeservice.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.resumeservice.security.details.UserDetailsImpl;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) return "home";
        else return "redirect:/profile";
    }
}
