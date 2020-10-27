package ru.itis.resumeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.security.details.UserDetailsImpl;
import ru.itis.resumeservice.services.ResumeService;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/resume/create")
    public String getCreatePage() {
        return "create_resume";
    }

    @PostMapping("/resume/create")
    public String uploadResume(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               ResumeDto resumeDto) {
        resumeService.uploadResume(userDetails.getApplicant().getId(), resumeDto);
        return "redirect:/profile";
    }
}
