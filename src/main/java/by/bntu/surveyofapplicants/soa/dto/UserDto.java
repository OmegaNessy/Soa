package by.bntu.surveyofapplicants.soa.dto;

import by.bntu.surveyofapplicants.soa.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class UserDto {
    private Long id;

    @Size(min = 8,max = 25, message = "Не больше 25 и не меньше 8")
    private String login;

    private Set<Role> roles;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,25}$",message = "Длинна от 8 до 25 символов. Обязательна 1 цифра и 1 строчная буква.")
    private String password;

    private String confirmedPassword;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
