package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
    List<Specialty> findSpecialtiesByParentId(Long id);
    List<Specialty> findAllByNameStartingWith(String searchString);
    Specialty findByName(String name);
}
