package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialtyController {
    @Autowired
    SpecialtyRepository repo;

    @GetMapping("/specialty/all")
    public List<Specialty> getAll(){
        return repo.findAll();
    }

    @GetMapping("/faculty/{id}/specialty")
    public List<Specialty> getSpecialty(@PathVariable Long id){
        return repo.findSpecialtiesByParentId(id);
    }

    @GetMapping("/specialty/search/{searchString}")
    public List<Specialty> getSpecialtiesBySearchString(@PathVariable String searchString){
        return repo.findAllByNameStartingWith(searchString);
    }
}
