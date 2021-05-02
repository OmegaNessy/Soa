package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {
    private Long id;
    private Long questionId;
    @NonNull
    private String answerText;
    @NonNull
    private String score;
}
