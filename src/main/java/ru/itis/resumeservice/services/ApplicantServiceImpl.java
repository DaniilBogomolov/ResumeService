package ru.itis.resumeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.resumeservice.dto.ApplicantDto;
import ru.itis.resumeservice.models.Applicant;
import ru.itis.resumeservice.repositories.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Applicant save(ApplicantDto applicantDto) {
        if(applicantRepository.findByEmail(applicantDto.getEmail()).isEmpty()) {
            applicantDto.setPassword(passwordEncoder.encode(applicantDto.getPassword()));
            Applicant applicant = Applicant.from(applicantDto);
            applicantRepository.save(applicant);
            return applicant;
        }
        throw new RuntimeException("Applicant account already exists");
    }
}
