package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {
    private Long id;
    private Long questionId;
    @NonNull
    @Size(min = 2, max = 40,message = "Вопрос не может быть пустым")
    private String answerText;
    @NotNull(message = "Не может быть пустым")
    private Integer score;
    @NotEmpty(message = "Не может быть пустым")
    private String membership;
}
