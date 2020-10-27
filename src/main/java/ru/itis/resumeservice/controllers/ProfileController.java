package ru.itis.resumeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.resumeservice.security.details.UserDetailsImpl;
import ru.itis.resumeservice.services.ApplicantService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
                             Model model) {
        model.addAttribute("profileInfo", applicantService.getProfile(userDetails.getApplicant().getId()));
        return "profile";
    }
}
