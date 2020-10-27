package ru.itis.resumeservice.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.resumeservice.models.Applicant;
import ru.itis.resumeservice.repositories.ApplicantRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Applicant> applicantCandidate = applicantRepository.findByEmail(email);
        if (applicantCandidate.isPresent()) {
            Applicant applicant = applicantCandidate.get();
            return new UserDetailsImpl(applicant);
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
