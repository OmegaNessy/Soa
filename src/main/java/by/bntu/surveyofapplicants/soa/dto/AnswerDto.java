package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {
    private Long id;
    private Long questionId;
    @NonNull
    @Size(min = 2, max = 255,message = "Вопрос не может быть пустым")
    private String answerText;
    @NotNull(message = "Не может быть пустым")
    @Min(value = 0,message = "Не меньше 0")
    @Max(value = 10,message = "Не больше 10")
    private Integer score;
    @NotEmpty(message = "Не может быть пустым")
    @Size(max=20,message = "Не больше 20 символов")
    private String membership;
}
