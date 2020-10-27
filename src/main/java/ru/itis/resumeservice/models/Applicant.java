package ru.itis.resumeservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
}
