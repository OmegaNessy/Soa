package by.bntu.surveyofapplicants.soa.dto;

import by.bntu.surveyofapplicants.soa.entity.Question;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class TestApiDto implements Serializable {
    private Long id;

    private String testType;

    private Long facultyId;

    private List<Question> questions;
}