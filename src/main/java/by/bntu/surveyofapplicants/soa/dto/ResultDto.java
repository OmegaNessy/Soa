package by.bntu.surveyofapplicants.soa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class ResultDto {
    @NonNull
    private ResultAttribute attribute;
}
