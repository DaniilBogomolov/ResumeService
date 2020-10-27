package ru.itis.resumeservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.itis.resumeservice.dto.ApplicantDto;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "applicant")
public class Applicant {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @DBRef
    private List<Resume> resumeList;


    public static Applicant from(ApplicantDto applicantDto) {
        return Applicant.builder()
                .email(applicantDto.getEmail())
                .firstName(applicantDto.getFirstName())
                .lastName(applicantDto.getLastName())
                .password(applicantDto.getPassword())
                .resumeList(EMPTY_LIST)
                .build();
    }
}
