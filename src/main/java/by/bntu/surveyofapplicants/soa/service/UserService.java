package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.UserDto;
import by.bntu.surveyofapplicants.soa.entity.Role;
import by.bntu.surveyofapplicants.soa.entity.User;
import by.bntu.surveyofapplicants.soa.mapper.UserMapper;
import by.bntu.surveyofapplicants.soa.repository.RoleRepository;
import by.bntu.surveyofapplicants.soa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper mapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(UserDto user) {
        User userFromForm = mapper.toEntity(user);
        User userFromDB = userRepository.findByLogin(userFromForm.getUsername());

        if (userFromDB != null) {
            return false;
        }

        userFromForm.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userFromForm.setPassword(bCryptPasswordEncoder.encode(userFromForm.getPassword()));
        userRepository.save(userFromForm);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
