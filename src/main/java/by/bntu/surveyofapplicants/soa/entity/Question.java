package by.bntu.surveyofapplicants.soa.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "QUESTION")
public class Question implements JsonIgnoreWraper, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToMany(targetEntity=Answer.class, mappedBy="question",cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Answer> answers;

    @Column(name = "QUESTYPE_ID")
    @NonNull
    private Long questype;

    @JsonBackReference
    @ManyToOne
    private Test test;

    @Column(name = "question")
    @NonNull
    private String questionText;

    public Question (Long id, Long questype, String questionText, Test test){
        this.id = id;
        this.questionText = questionText;
        this.questype = questype;
        this.test = test;
    }
}
