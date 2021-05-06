package by.bntu.surveyofapplicants.soa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private Long id;
    private Long testId;
    private String score;
    private Long studentId;
}
