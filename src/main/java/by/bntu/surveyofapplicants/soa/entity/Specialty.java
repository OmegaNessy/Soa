package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SPECIALTY")
public class Specialty implements JsonIgnoreWraper{
    @Id
    @NonNull
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
