package by.bntu.surveyofapplicants.soa.dto;

import by.bntu.surveyofapplicants.soa.entity.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class UserDto {
    private Long id;

    @NotEmpty(message = "Логин не может быть пустым")
    private String login;

    private Set<Role> roles;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,25}$",message = "Длинна от 8 до 25 символов. Обязательна 1 цифра и 1 строчная буква.")
    private String password;

    private String confirmedPassword;

    public UserDto() {
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
