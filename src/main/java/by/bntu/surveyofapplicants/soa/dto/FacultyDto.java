package by.bntu.surveyofapplicants.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;

    @NonNull
    @Size(min = 2, max = 4, message = "Должно содержать от 2 до 4 символов")
    private String name;

    @NonNull
    @Pattern(regexp = "([0-4]{1}\\.[0-9]?)|[5]\\.[0]|[5]", message = "Должно соответствовать формату Ч.Ч. Не больше 5")
    private String hostelRating;

    @NonNull
    @Pattern(regexp = "([0-4]{1}\\.[0-9]?)|[5]\\.[0]|[5]", message = "Должно соответствовать формату Ч.Ч. Не больше 5" )
    private String studyRating;

    @NonNull
    @Pattern(regexp = "([0-4]{1}\\.[0-9]?)|[5]\\.[0]|[5]", message = "Должно соответствовать формату Ч.Ч. Не больше 5" )
    private String studentAssetRating;

    @NonNull
    @Pattern(regexp = "([0-4]{1}\\.[0-9]?)|[5]\\.[0]|[5]", message = "Должно соответствовать формату Ч.Ч. Не больше 5" )
    private String facultyRating;

    @NonNull
    @Size(min = 1, max = 3, message = "Поле обязательно должно быть заполнено")
    private String campus;

    @NonNull
    @Size(min = 50, max = 4000, message = "Должно содержать от 50 до 2048 символов")
    private String information;

    @NonNull
    @Size(min = 10, max = 100, message = "Должно содержать от 10 до 50 символов")
    private String shortInformation;
}
