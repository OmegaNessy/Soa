package by.bntu.surveyofapplicants.soa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ANSWERS")
public class Answer implements JsonIgnoreWraper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    private Question question;

    @Column(name = "SCORE")
    @NonNull
    private Integer score;

    @Column(name = "ANSWER")
    @NonNull
    private String answerText;

    @Column(name = "MEMBERSHIP")
    @NonNull
    private String membership;

    public Answer (Question question, String answerText, Integer score){
        this.question = question;
        this.answerText = answerText;
        this.score = score;
    }
//
//    @Column(name = "FACULTY_ID")
//    private Long facultyId;
}
