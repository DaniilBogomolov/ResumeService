package ru.itis.resumeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewResumeDto {
    private String name;
    private String about;
    private String workExperience;
    private String education;
    private String skills;
    private String references;
}
