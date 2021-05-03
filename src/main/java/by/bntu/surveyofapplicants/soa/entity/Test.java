package by.bntu.surveyofapplicants.soa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEST")
public class Test implements JsonIgnoreWraper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TESTTYPE")
    @NonNull
    private String testType;

    @JsonManagedReference
    @OneToMany(targetEntity=Question.class, mappedBy="test",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

    @Column(name = "faculty_id")
    private Long facultyId;

    public Test(Long id,String testType, Long facultyId){
        this.id = id;
        this.testType = testType;
        this.facultyId = facultyId;
    }
}
