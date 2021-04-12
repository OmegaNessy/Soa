package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FACULTIES")
public class Faculty implements JsonIgnoreWraper {
    @Id
    @NonNull
    private Long id;

    @Column(name = "NAME")
    @NonNull
    private String name;

    @Column(name = "HOSTEL_RATING")
    @NonNull
    private Float hostelRating;

    @Column(name = "STUDY_RATING")
    @NonNull
    private Float studyRating;

    @Column(name = "STUDENTASSET_RATING")
    @NonNull
    private Float studentAssetRating;

    @Column(name = "FACULTY_RATING")
    @NonNull
    private Float facultyRating;

    @Column(name = "CAMPUS")
    @NonNull
    private String campus;

    @Column(name = "INFORMATION")
    @NonNull
    private String information;

    @Column(name = "SHORT_INFORMATION")
    @NonNull
    private String shortInformation;
}