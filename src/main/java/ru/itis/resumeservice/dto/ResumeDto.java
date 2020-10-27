package ru.itis.resumeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.resumeservice.models.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDto {

    private String firstName;
    private String lastName;
    private String id;
    private String name;
    private String about;
    private String workExperience;
    private String education;
    private String skills;
    private String references;

    public static ResumeDto from(Resume resume) {
        return ResumeDto.builder()
                .firstName(resume.getOwner().getFirstName())
                .lastName(resume.getOwner().getLastName())
                .id(resume.getId())
                .name(resume.getName())
                .about(resume.getAbout())
                .workExperience(resume.getWorkExperience())
                .education(resume.getEducation())
                .skills(resume.getSkills())
                .references(resume.getReferences())
                .build();
    }
}
