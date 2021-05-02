package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student implements JsonIgnoreWraper{
    @Id
    @NonNull
    private Long id;

    @Column(name = "NAME")
    @NonNull
    private String name;

    @Column(name = "SURNAME")
    @NonNull
    private String surname;

    @Column(name = "CITY")
    @NonNull
    private String city;

    @Column(name = "TELEPHONE")
    private String telephone;
}
