package ru.itis.resumeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.resumeservice.dto.NewResumeDto;
import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.models.Applicant;
import ru.itis.resumeservice.models.Resume;
import ru.itis.resumeservice.repositories.ApplicantRepository;
import ru.itis.resumeservice.repositories.ResumeRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume uploadResume(String uploaderId, NewResumeDto resumeDto) {
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
    public ResumeDto getById(String id) {
        Optional<Resume> resumeCandidate = resumeRepository.findById(id);
        if (resumeCandidate.isPresent()) {
            return ResumeDto.from(resumeCandidate.get());
        } throw new IllegalStateException("No resume found");
    }

    @Override
    public String getOwnerId(String id) {
        Optional<Resume> resumeCandidate = resumeRepository.findById(id);
        if (resumeCandidate.isPresent()) {
            return resumeCandidate.get().getOwner().getId();
        } throw new IllegalStateException("No resume found");
    }

    @Override
    public void delete(String callerId, String id) {
        Optional<Resume> resumeCandidate = resumeRepository.findById(id);
        if (resumeCandidate.isPresent()) {
            Resume resume = resumeCandidate.get();
            if (resume.getOwner().getId().equals(callerId)) {
                Applicant owner = applicantRepository.findById(callerId).get();
                owner.setResumeList(
                        owner.getResumeList().stream()
                                .filter(res -> !res.getId().equals(id))
                                .collect(Collectors.toList())
                );
                applicantRepository.save(owner);
                resumeRepository.delete(resume);
            } else throw new IllegalStateException("No permission");
        } else throw new IllegalStateException("No resume found");
    }

    @Override
    public void update(String callerId, String id, NewResumeDto resumeDto) {
        Optional<Resume> resumeCandidate = resumeRepository.findById(id);
        if (resumeCandidate.isPresent()) {
            Resume resume = resumeCandidate.get();
            if (resume.getOwner().getId().equals(callerId)) {
                updateResume(resume, resumeDto);
                resumeRepository.save(resume);
            } else throw new IllegalStateException("No permission");
        } else throw new IllegalStateException("No resume found");
    }

    private Resume updateResume(Resume oldResume, NewResumeDto resumeDto) {
        oldResume.setName(resumeDto.getName());
        oldResume.setAbout(resumeDto.getAbout());
        oldResume.setEducation(resumeDto.getEducation());
        oldResume.setReferences(resumeDto.getReferences());
        oldResume.setSkills(resumeDto.getSkills());
        oldResume.setWorkExperience(resumeDto.getWorkExperience());
        return oldResume;
    }
}
