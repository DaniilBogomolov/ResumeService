package ru.itis.resumeservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.resumeservice.models.Applicant;

import java.util.Optional;

public interface ApplicantRepository extends MongoRepository<Applicant, String> {
    Optional<Applicant> findByEmail(String email);
}
