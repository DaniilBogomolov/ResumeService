package ru.itis.resumeservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.resumeservice.models.Resume;

public interface ResumeRepository extends MongoRepository<Resume, String> {
}
