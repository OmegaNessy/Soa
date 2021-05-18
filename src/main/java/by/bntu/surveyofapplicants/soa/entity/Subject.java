package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUBJECTS")
public class Subject implements JsonIgnoreWraper {
    @Id
    @NonNull
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;
}
