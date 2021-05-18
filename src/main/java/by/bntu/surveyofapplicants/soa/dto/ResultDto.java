package by.bntu.surveyofapplicants.soa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private String score;
    private List<ResultAttribute> attributes;
}
