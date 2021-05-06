package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Serializable {
    private Long id;
    @NonNull
    private String questionType;
    @NonNull
    @Size(min = 5, max = 200, message = "Поле должно содержать от 4 до 200 символов")
    private String question;
    private Long testId;
}
