package ru.itis.resumeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.resumeservice.models.Applicant;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {

    private String userId;
    private List<ProfileResumeDto> resumeDtoList;

    public static ProfileDto from(Applicant applicant) {
        return ProfileDto.builder()
                .userId(applicant.getId())
                .resumeDtoList(List.copyOf(
                        applicant.getResumeList().stream()
                                .map(ProfileResumeDto::from)
                                .collect(Collectors.toList()
                                ))
                )
                .build();
    }
}

