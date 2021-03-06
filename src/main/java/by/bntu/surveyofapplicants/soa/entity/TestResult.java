package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "tests_results")
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

    @Column(name = "DATE")
    @NonNull
    private Date date;


    public TestResult(Long testId, Long studentId, String score, Date date){
        this.testId = testId;
        this.studentId = studentId;
        this.score = score;
        this.date = date;
    }

}
