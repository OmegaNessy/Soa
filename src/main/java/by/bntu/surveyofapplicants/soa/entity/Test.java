package by.bntu.surveyofapplicants.soa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tests")
public class Test implements JsonIgnoreWraper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_information")
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
