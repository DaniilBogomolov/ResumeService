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
public class SignUpController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }


    @PostMapping("/signUp")
    public String signUp(ApplicantDto applicant) {
        applicantService.save(applicant);
        return "redirect:/home";
    }
}
