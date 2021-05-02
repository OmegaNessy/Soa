package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "SPECIALTY")
public class Specialty implements JsonIgnoreWraper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "PARENT_ID")
//    private Faculty faculty;

    @Column(name = "PARENT_ID")
    @NonNull
    private Long parentId;

    @Column(name = "NAME")
    @NonNull
    private String name;

    @Column(name = "INFORMATION")
    @NonNull
    private String information;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "FIRST_SUBJECT_ID")
//    @NonNull
//    private Subject firstSubjectId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SECOND_SUBJECT_ID")
//    @NonNull
//    private Subject secondSubjectId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "THIRD_SUBJECT_ID")
//    @NonNull
//    private Subject thirdSubjectId;

    @Column(name = "FIRST_SUBJECT_ID")
    @NonNull
    private Long firstSubjectId;

    @Column(name = "SECOND_SUBJECT_ID")
    @NonNull
    private Long secondSubjectId;

    @Column(name = "THIRD_SUBJECT_ID")
    @NonNull
    private Long thirdSubjectId;

    @Column(name = "PASSING_SCORE")
    @NonNull
    private Integer passingScore;

}
