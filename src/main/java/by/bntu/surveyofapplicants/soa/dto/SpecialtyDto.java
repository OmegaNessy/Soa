package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDto implements Serializable {
    private Long id;
    @NonNull
    @Size(min = 2, max = 20, message = "Введите название специальности. От 2 до 20 символов")
    private String name;

    @NonNull
    private String facultyName;

    @NonNull
    @Size(min = 50, max = 2048, message = "Должно содержать от 50 до 2048 символов")
    private String information;

    @NonNull
    @Pattern(regexp = "[0-9]{3}", message = "Обязательно для ввода")
    private String passingScore;

    @NonNull
    private String firstSubjectName;

    @NonNull
    private String secondSubjectName;

    @NonNull
    private String thirdSubjectName;
}
