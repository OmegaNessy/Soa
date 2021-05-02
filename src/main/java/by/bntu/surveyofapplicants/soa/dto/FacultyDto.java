package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Float hostelRating;

    @NonNull
    private Float studyRating;

    @NonNull
    private Float studentAssetRating;

    @NonNull
    private Float facultyRating;

    @NonNull
    private String campus;

    @NonNull
    private String information;

    @NonNull
    private String shortInformation;
}
