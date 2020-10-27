package ru.itis.resumeservice.services;

import ru.itis.resumeservice.dto.ApplicantDto;
import ru.itis.resumeservice.dto.ProfileDto;
import ru.itis.resumeservice.models.Applicant;

public interface ApplicantService {
    Applicant save(ApplicantDto applicantDto);
    ProfileDto getProfile(String applicantId);
}
