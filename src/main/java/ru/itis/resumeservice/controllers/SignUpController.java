package ru.itis.resumeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.resumeservice.dto.ApplicantDto;
import ru.itis.resumeservice.models.Applicant;
import ru.itis.resumeservice.services.ApplicantService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public String getSignUpPage() {
        return "sign_up";
    }


    @PostMapping
    @PreAuthorize("permitAll()")
    public String signUp(ApplicantDto applicant) {
        applicantService.save(applicant);
        return "redirect:/home";
    }
}
