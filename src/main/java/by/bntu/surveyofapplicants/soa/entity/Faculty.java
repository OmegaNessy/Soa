package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FACULTIES")
public class Faculty implements JsonIgnoreWraper, IdentityCheckable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
