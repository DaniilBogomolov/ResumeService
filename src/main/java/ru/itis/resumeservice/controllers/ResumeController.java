package ru.itis.resumeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.itis.resumeservice.dto.NewResumeDto;
import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.security.details.UserDetailsImpl;
import ru.itis.resumeservice.services.ApplicantService;
import ru.itis.resumeservice.services.ResumeService;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/resume/create")
    public String getCreatePage() {
        return "create_resume";
    }

    @PostMapping("/resume/create")
    public String uploadResume(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               NewResumeDto resumeDto) {
        resumeService.uploadResume(userDetails.getApplicant().getId(), resumeDto);
        return "redirect:/profile";
    }

    @GetMapping("/resume/get/{id}")
    @PreAuthorize("permitAll()")
    public String getResume(@AuthenticationPrincipal UserDetailsImpl userDetails,
                            @PathVariable String id,
                            Model model) {
        model.addAttribute("resumeInfo", resumeService.getById(id));
        String ownerId = resumeService.getOwnerId(id);
        if (userDetails != null && userDetails.getApplicant().getId().equals(ownerId))
            model.addAttribute("ownerId", ownerId);
        return "resume";
    }

    @PostMapping("/resume/delete/{id}")
    public String deleteResume(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               @PathVariable String id) {
        resumeService.delete(userDetails.getApplicant().getId(), id);
        return "redirect:/profile";
    }

    @PostMapping("/resume/update/{id}")
    public String updateResume(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               @PathVariable String id,
                               NewResumeDto resumeDto) {
        resumeService.update(userDetails.getApplicant().getId(), id, resumeDto);
        return "redirect:/resume/get/".concat(id);
    }
}
