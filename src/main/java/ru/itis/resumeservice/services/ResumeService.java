package ru.itis.resumeservice.services;

import ru.itis.resumeservice.dto.NewResumeDto;
import ru.itis.resumeservice.dto.ResumeDto;
import ru.itis.resumeservice.models.Resume;

public interface ResumeService {
    Resume uploadResume(String uploaderId, NewResumeDto resumeDto);
    ResumeDto getById(String id);
    String getOwnerId(String id);
    void delete(String callerId, String id);
    void update(String callerId, String id, NewResumeDto resumeDto);
}
