package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
}
