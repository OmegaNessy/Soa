package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEST_RESULT")
public class TestResult implements JsonIgnoreWraper{
    @Id
    @NonNull
    private Long id;

    @Column(name = "TEST_ID")
    @NonNull
    private Long testId;

    @Column(name = "STUDENT_ID")
    @NonNull
    private Long studentId;

    @Column(name = "RESULT")
    @NonNull
    private String score;
}
