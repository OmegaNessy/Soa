package by.bntu.surveyofapplicants.soa.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDto {
    private FacultyDto faculty;
    private SpecialtyDto specialty;
    private String otherResult;
}
