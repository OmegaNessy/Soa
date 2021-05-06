package by.bntu.surveyofapplicants.soa.dto;

import lombok.Data;

import java.util.List;

@Data
public class MobileDto {
    private Long testId;
    private List<Long> answers;
    private String name;
    private String surname;
    private String city;
    private String telephone;
}
