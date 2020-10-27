package ru.itis.resumeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.models.Applicant;
import ru.itis.resumeservice.models.Resume;
import ru.itis.resumeservice.repositories.ApplicantRepository;
import ru.itis.resumeservice.repositories.ResumeRepository;

import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume uploadResume(String uploaderId, ResumeDto resumeDto) {
        Optional<Applicant> applicantCandidate = applicantRepository.findById(uploaderId);
        if (applicantCandidate.isPresent()) {
            Applicant applicant = applicantCandidate.get();
            Resume newResume = Resume.builder()
                    .name(resumeDto.getName())
                    .about(resumeDto.getAbout())
                    .education(resumeDto.getEducation())
                    .owner(applicant)
                    .references(resumeDto.getReferences())
                    .skills(resumeDto.getSkills())
                    .workExperience(resumeDto.getWorkExperience())
                    .build();
            resumeRepository.save(newResume);
            applicant.getResumeList().add(newResume);
            applicantRepository.save(applicant);
            return newResume;
        } throw new IllegalStateException("No applicant found");
    }

    @Override
    public ResumeDto findById(String id) {
        return null;
    }
}
