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
@Table(name = "TEST_RESULT")
public class TestResult implements JsonIgnoreWraper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TEST_ID")
    @NonNull
    private Long testId;

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "RESULT")
    @NonNull
    private String score;

    public TestResult(Long testId, Long studentId, String score){
        this.testId = testId;
        this.studentId = studentId;
        this.score = score;
    }
}