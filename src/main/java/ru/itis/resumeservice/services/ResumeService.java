package ru.itis.resumeservice.services;

import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.models.Resume;

public interface ResumeService {
    Resume uploadResume(String uploaderId, ResumeDto resumeDto);

    ResumeDto findById(String id);
}
