package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.UserDto;
import by.bntu.surveyofapplicants.soa.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    boolean deleteUser(Long userId);
    User findUserById(Long userId);
    boolean saveUser(UserDto user);
}
