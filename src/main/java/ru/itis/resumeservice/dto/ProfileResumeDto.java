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
public class ProfileResumeDto {

    private String id;
    private String name;

    public static ProfileResumeDto from(Resume resume) {
        return ProfileResumeDto.builder()
                .id(resume.getId())
                .name(resume.getName())
                .build();
    }
}
