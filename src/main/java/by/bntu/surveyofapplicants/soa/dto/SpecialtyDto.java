package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDto implements Serializable {
    @NonNull
    private String name;

    @NonNull
    private String facultyName;

    @NonNull
    private String information;

    @NonNull
    private String passingScore;

    @NonNull
    private String firstSubjectName;

    @NonNull
    private String secondSubjectName;

    @NonNull
    private String thirdSubjectName;
}
