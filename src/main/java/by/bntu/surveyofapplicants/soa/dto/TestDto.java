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
public class TestDto implements Serializable {
    private Long id;
    @NonNull
    @Size(min = 4, max = 100, message = "Поле от 4 до 100 символов")
    private String testType;

    private String facultyName;

}
