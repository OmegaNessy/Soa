package by.bntu.surveyofapplicants.soa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "STUDENT")
public class Student implements JsonIgnoreWraper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "CITY")
    private String city;

    @Column(name = "TELEPHONE")
    private String telephone;
}
