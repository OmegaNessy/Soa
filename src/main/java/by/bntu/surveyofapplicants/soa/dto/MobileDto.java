package by.bntu.surveyofapplicants.soa.dto;

import by.bntu.surveyofapplicants.soa.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class MobileDto {
    private Long testId;
    private List<Long> answersIds;
    private Student student;
}
