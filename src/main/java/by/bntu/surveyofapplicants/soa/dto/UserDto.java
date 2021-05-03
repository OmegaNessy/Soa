package by.bntu.surveyofapplicants.soa.dto;

import by.bntu.surveyofapplicants.soa.entity.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {
    private Long id;

    @NotBlank(message = "Login cant be empty")
    @NotEmpty(message = "Login cant be empty")
    private String login;

    private Set<Role> roles;

    @Size(min = 8, max = 25, message = "Длинна от 8 до 25 символов. Обязательна 1 цифра и 1 строчная буква. Запрещены специальные символы.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}$")
    private String password;

    private String confirmedPassword;

    public UserDto() {
    }

    public UserDto(Long id, @NotBlank(message = "Login cant be empty") @NotEmpty(message = "Login cant be empty") String login, Set<Role> roles, @Size(min = 8, max = 25, message = "Длинна от 8 до 25 символов. Обязательна 1 цифра и 1 строчная буква. Запрещены специальные символы.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}$") String password, String confirmedPassword) {
        this.id = id;
        this.login = login;
        this.roles = roles;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
