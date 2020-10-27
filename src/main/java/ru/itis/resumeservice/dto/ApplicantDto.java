package ru.itis.resumeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
