package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    FacultyRepository repo;

    @GetMapping("/faculty/all")
    public List<Faculty> getAll(){
        return repo.findAll();
    }

    @GetMapping("/faculty/{id}")
    public Faculty getById(@PathVariable Long id){
        return repo.findById(id).orElseThrow(NullPointerException::new);
    }

    @GetMapping("/faculty/search/{searchString}")
    public List<Faculty> getSpecialtiesBySearchString(@PathVariable String searchString){
        return repo.findAllByNameStartingWith(searchString);
    }
}
