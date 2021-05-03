package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotBlank
    private Float hostelRating;

    @NonNull
    @NotBlank
    private Float studyRating;

    @NonNull
    @NotBlank
    private Float studentAssetRating;

    @NonNull
    @NotBlank
    private Float facultyRating;

    @NonNull
    @NotBlank
    private String campus;

    @NonNull
    @NotBlank
    private String information;

    @NonNull
    @NotBlank
    private String shortInformation;
}
